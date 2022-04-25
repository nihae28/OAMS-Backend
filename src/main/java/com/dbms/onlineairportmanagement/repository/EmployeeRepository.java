package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Employee getByEmailId(String emailId);
}
