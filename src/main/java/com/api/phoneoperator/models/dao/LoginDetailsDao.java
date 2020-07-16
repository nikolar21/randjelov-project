package com.api.phoneoperator.models.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "login_details")
public class LoginDetailsDao {
    @Id
    private String email;
    private String password;
}
