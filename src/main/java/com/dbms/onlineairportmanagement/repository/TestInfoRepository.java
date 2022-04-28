package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Test_info;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestInfoRepository extends CrudRepository<Test_info, String> {
    @Override
    List<Test_info> findAll();
}
