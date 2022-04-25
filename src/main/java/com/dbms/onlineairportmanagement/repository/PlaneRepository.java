package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, Integer> {
}
