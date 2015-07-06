package com.rootnext.spring.app.models;

/**
 * Created by sanjoy on 7/6/15.
 */
public class Employee {
    private Long id;
    private String name;
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
