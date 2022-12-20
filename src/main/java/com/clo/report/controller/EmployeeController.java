package com.clo.report.controller;

import com.clo.report.domain.Employee;
import com.clo.report.repository.EmployeeRepository;
import com.clo.report.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    /**
     * GET 전체 직원 정보를 가져옵니다.
     * @return
     */
    @ResponseBody
    @GetMapping("/api/employee")
    public List<Employee> getEmployeeAll() {
        return employeeRepository.findAll();
    }

    /**
     * GET 특정 이름으로 검색한 직원 정보를 가져옵니다.
     * @param name
     * @return
     */
    @ResponseBody
    @GetMapping("/api/employee/{name}")
    public List<Employee> getEmployeeByName(@PathVariable("name") String name) {
        return employeeRepository.findByName(name);
    }

    /**
     * POST 직원 정보를 추가합니다.
     * @param employee
     * @return
     */
    @PostMapping("/api/employee")
    public ResponseEntity setEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
