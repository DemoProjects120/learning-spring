package com.rootnext.spring.app.models;

import javax.persistence.*;

/**
 * Created by sanjoy on 7/6/15.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Float salary;

    public Employee(){

    }

    public Employee(Long id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String toString(){
        return "[" + id + ", '"+name+"', "+salary+"]" ;
    }
}
