package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.LoginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepository extends JpaRepository<LoginDetails, String> {
    // implement CRUD methods

}
