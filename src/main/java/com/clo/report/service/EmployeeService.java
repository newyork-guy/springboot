package com.clo.report.service;

import com.clo.report.domain.Employee;
import com.clo.report.repository.EmployeeRepository;

import com.opencsv.CSVReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service
public class EmployeeService {

    @Value("${path.csv}")
    String csvPath;

    @Value("${path.json}")
    String jsonPath;

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void jsonInit() {
        /**
         * JSON 파일을 초기에 읽어서, DB에 쌓아둔다.
         */
        try {
            // JSON 파일 읽어오기
            Reader reader = new FileReader(jsonPath);

            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;

            if (!jsonArray.isEmpty()) {
                for (int i=0; i<jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    entityMapping(jsonObject.get("name").toString(),
                                  jsonObject.get("email").toString(),
                                  jsonObject.get("tel").toString(),
                                  jsonObject.get("joined").toString());
                }
            }
        } catch (Exception e) {
            System.out.printf("Exception: %s", e);
        }
    }

    @Transactional
    public void csvInit() {
        /**
         * CSV 파일을 초기에 읽어서, DB에 쌓아둔다.
         */
        try {
            // CSV 파일 읽어오기
            CSVReader reader = new CSVReader(new FileReader(csvPath), ',');
            String[] record = null;
            while ((record = reader.readNext()) != null) {
                entityMapping(record[0],record[1],record[2],record[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    private void entityMapping(String name, String email, String tel, String joined) {
        /**
         * 엔티티에 맵핑하고 h2DB에 넣어둔다.
         */

        // validation
        if (joined.contains(".")) {
            joined.replace('.','-');
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Employee employee = new Employee();
        employee.setName(name.trim());
        employee.setEmail(email.trim());
        employee.setTel(tel.trim());
        employee.setJoined(LocalDate.parse(joined.trim(),formatter));

        employeeRepository.save(employee);
    }
}
