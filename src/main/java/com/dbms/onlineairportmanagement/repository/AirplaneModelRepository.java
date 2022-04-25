package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.AirplaneModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneModelRepository extends CrudRepository<AirplaneModel, Integer> {

}
