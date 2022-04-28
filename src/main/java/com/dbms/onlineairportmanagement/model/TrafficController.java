package com.dbms.onlineairportmanagement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trafficcontroller")
public class TrafficController {

    @Id
    @Column(name = "ssn")
    String ssn;

    @Column(name = "exam_date")
    LocalDateTime exam_date;
}