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
@Table(name = "LoginDetails")
public class LoginDetails {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
