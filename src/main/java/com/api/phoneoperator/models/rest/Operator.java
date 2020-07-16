package com.api.phoneoperator.models.rest;

import com.api.phoneoperator.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operator extends User {
    private String positionName;
}
