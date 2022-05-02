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
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "Ssn")
    private String ssn;

    @Column(name = "Email")
    private String emailId;

    @Column(name = "EName")
    private String eName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Salary")
    private Long salary;

    @Column(name = "Union_mem_no")
    private String unionNo;

    @Column(name = "Phone_no")
    private long phone;

    @Column(name = "ERole")
    private String role;
}
