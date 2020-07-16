package com.api.phoneoperator.models.dao;

import com.api.phoneoperator.models.User;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "clients")
public class Client extends User {
    private int minutesLeft;
    private int megabytesLeft;
    private int messagesLeft;
}
