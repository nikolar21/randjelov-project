package com.api.phoneoperator.models.dao;

import com.api.phoneoperator.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clients")
public class ClientDao extends User {
    @Column(name = "minutes_left")
    private int minutesLeft;
    @Column(name = "megabytes_left")
    private int megabytesLeft;
    @Column(name = "messages_left")
    private int messagesLeft;
    @Column(name = "payment_needed")
    private double paymentAmount;
    @Column(name = "has_payed")
    private boolean hasPayed;
}
