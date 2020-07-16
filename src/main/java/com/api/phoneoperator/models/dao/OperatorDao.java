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
@Table(name = "operators")
public class OperatorDao extends User {
    @Column(name = "position_name")
    private String positionName;
}
