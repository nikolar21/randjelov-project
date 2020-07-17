package com.api.phoneoperator.models.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcesInfo {
    private String clientEmail;
    private int minutesToAdd;
    private int megabytesToAdd;
    private int messagesToAdd;
}
