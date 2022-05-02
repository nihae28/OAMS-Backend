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
@Table(name = "faa_test")
public class FAATest {

    @Id
    @Column(name = "FAA_no")
    String faaNo;

    @Column(name = "Tname")
    String tName;

    @Column(name = "max_score")
    int maxScore;
}
