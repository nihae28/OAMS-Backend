package com.dbms.onlineairportmanagement.model;
import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="test_info")
public class Test_info {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "FAA_no",nullable = false)
    private String faa_no;

    @Column(name = "Reg_no",nullable = false)
    private String reg_no;

    @Column(name = "Ssn",nullable = false)
    private String ssn;

    @Column(name = "Hours",nullable = false)
    private int hours;

    @Column(name = "TDate",nullable = false)
    private Date tdate;

    @Column(name = "Score",nullable = false)
    private int score;

}
