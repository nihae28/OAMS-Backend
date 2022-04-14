package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // implement CRUD methods

}
