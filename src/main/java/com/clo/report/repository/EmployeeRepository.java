package com.clo.report.repository;

import com.clo.report.domain.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepository {

    @PersistenceContext
    private EntityManager em;

    public String save (Employee employee) {
        em.persist(employee);
        return "Created";
    }

    public List<Employee> findAll() {
        return em.createQuery("select m from Employee m", Employee.class)
                .getResultList();
    }

    public List<Employee> findByName(String name) {
        return em.createQuery("select m from Employee m where m.name = :name", Employee.class)
                .setParameter("name", name)
                .getResultList();
    }
}
