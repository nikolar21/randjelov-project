package com.api.phoneoperator.models.rest;

import com.api.phoneoperator.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User {
    private int minutesLeft;
    private int megabytesLeft;
    private int messagesLeft;
    private double paymentAmount;
    private boolean hasPayed;
}
