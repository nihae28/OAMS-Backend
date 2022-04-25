package com.dbms.onlineairportmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TEST_INFO")
public class TestInfo {

    @Id
    @Column(name = "FAA_no")
    String faa_no;

    @Column(name = "Reg_no")
    int Reg_no;

    @Column(name = "Ssn")
    String Ssn;

    @Column(name = "Hours")
    int Hours;

    @Column(name = "TDate")
    Date TDate;

    @Column(name = "Score")
    int Score;
}
