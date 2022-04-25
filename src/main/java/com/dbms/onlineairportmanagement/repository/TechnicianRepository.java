package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Technician;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends CrudRepository<Technician, String> {
}
