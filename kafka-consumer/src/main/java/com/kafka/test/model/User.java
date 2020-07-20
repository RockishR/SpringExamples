package com.kafka.test.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    int id;
    String name;
    String mobileNo;
    String address;
}
