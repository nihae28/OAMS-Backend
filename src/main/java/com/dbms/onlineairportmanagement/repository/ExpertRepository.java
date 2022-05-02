package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Expert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends CrudRepository<Expert, Integer> {

}
