package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.FAATest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FAATestRepository extends CrudRepository<FAATest, String> {
}
