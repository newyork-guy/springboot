package com.clo.report.configure;

import com.clo.report.repository.EmployeeRepository;
import com.clo.report.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class InitDB {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;

    @PostConstruct
    public void init() {
        /**
         * csv파일을 읽어오고, h2db로 전송한다.
         */
        employeeService.csvInit();
        /**
         * json파일을 읽어오고, h2db로 전송한다.
         */
        employeeService.jsonInit();
    }

}
