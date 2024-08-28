package com.ashish.Spring_MVC_crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String employee_name;

    @Column
    private String address;

    @Column
    private int age;

    @Column
    private long phone;

    @Column
    private long aadhar;

    @Column
    private String email;
}
