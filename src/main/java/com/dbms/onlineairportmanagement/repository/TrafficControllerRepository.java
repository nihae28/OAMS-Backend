package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.TrafficController;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrafficControllerRepository extends CrudRepository<TrafficController, String> {
    abstract TrafficController getTrafficControllerBySsn(String ssn);
}
