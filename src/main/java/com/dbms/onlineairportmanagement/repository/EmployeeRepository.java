package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

    Employee getByEmailId(String emailId);
}
