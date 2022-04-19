package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailsRepository extends JpaRepository<LoginDetails, String> {
    // implement CRUD methods

}
