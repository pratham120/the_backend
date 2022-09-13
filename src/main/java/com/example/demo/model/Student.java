package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    private Integer id;
    private String name;
    private String address;

    {

        this.address = address;
    }

    public Student() {

    }

    public Integer getId() {
        return id;
    }
}