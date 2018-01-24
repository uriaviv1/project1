package com.example.aviv.project1;

/**
 * Created by Aviv on 16/12/2017.
 */

public class NewUser extends Person {
    private String email;
    private int age;
    private String password;
    public NewUser(String firstName, String lastName, String email, String password , int age) {
        super(firstName, lastName);
        if(email!="") {
            this.email = email;
        }
        if(age!=0) {
            this.age = age;
        }
        if(password!=""&&password.length()>6) {
            this.password = password;
        }
    }
    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }




    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
