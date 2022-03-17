package com.example.MyWebService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Thing {

    @Id
    @GeneratedValue
    private int id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Thing()
    {}

    public Thing(String name)
    {
        super();
        this.name=name;
    }

}
