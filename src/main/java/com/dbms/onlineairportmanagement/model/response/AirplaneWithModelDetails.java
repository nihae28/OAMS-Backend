package com.dbms.onlineairportmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneWithModelDetails {
    private int regNo;
    private int modelNo;
    private int capacity;
    private int weight;
}
