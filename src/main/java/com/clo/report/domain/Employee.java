package com.clo.report.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Employee {

    @Id @GeneratedValue
    private Long id;                 // ID
    private String name;             // 이름
    private String email;            // 이메일
    private String tel;              // 전화번호
    private LocalDate joined;           // 입사일

}
