package com.jubaw.domain;


import com.jubaw.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_role")
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;


    @Enumerated(EnumType.STRING)
    @Column(length = 30,nullable = false)
    private UserRole name;


    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                '}';
    }
}
