package org.launchcode.Songs4Soldiers.models;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User extends AbstractEntity {

    @Id
    @GeneratedValue
    private int userId;

    @Email(message = "Invalid email. Try again.")
    @Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String email;

    @Size(min = 10, max = 12, message = "Too many digits! format: 000-555-1234")
    private String phone;

    public User(int userId, String email, String phone) {
        this.userId = userId;
        this.email = email;
        this.phone = phone;
    }

    public User(){}

    //Getters and setters
    public int getUserID() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }




}