package com.dbms.onlineairportmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "model")
public class AirplaneModel {

    @Id
    @Column(name = "Model_no")
    int modelNo;

    @Column(name = "capacity")
    int capacity;

    @Column(name = "weight")
    int weight;
}
