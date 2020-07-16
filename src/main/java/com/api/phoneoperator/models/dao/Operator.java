package com.api.phoneoperator.models.dao;

import com.api.phoneoperator.models.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "operators")
public class Operator extends User {
    private String nesta;
}
