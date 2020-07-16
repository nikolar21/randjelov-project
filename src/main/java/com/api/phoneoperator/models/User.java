package com.api.phoneoperator.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Id;

@Data
@MappedSuperclass
@Table
public class User {
    private String firstName;
    private String lastName;
    private int age;
    @Id
    private String email;
    private String password;
    private String accountType;
}
