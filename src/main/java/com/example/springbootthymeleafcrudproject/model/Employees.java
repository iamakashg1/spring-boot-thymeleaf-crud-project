package com.example.springbootthymeleafcrudproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity (name = "Employee_Management")
public class Employees {
    @Id
    @GeneratedValue
    long id;
    @Column(name = "First_Name")
    String firstName;
    @Column(name = "Last_Name")
    String lastName;
    @Column(name = "Emailid")
    String email;

    // Getter Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
