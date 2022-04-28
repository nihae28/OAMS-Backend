package com.dbms.onlineairportmanagement.repository;

import com.dbms.onlineairportmanagement.model.Plane;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, Integer> {
    public List<Plane> findByRegNo(int regNo);
}
