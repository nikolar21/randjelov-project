package com.api.phoneoperator.models.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllClientsResponse {
    private String status;
    private List<Client> clientArray;
}
