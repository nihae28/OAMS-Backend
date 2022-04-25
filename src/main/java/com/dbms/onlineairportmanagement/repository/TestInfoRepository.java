package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.TestInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestInfoRepository extends CrudRepository<TestInfo, String> {
}
