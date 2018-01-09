package com.example.aviv.project1;

/**
 * Created by Aviv on 16/12/2017.
 */

public class Person {
    protected String firstName;
    protected String lastName;
    protected Person(String firstName, String lastName) {
        if(firstName!=""){
        this.firstName = firstName;}
        if(lastName!=""){
        this.lastName = lastName;}
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }



}
