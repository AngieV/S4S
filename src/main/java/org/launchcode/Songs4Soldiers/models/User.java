package org.launchcode.Songs4Soldiers.models;

import javax.annotation.processing.Generated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class User {

    //@Generated()
    //private final int userID;
    private int userID;
    private static int nextId = 1;

    @NotBlank (message = "Name is required")
    private String name;

    @NotBlank(message = "Name is required")
    @Email(message = "Invalid email. Try again.")
    //@Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String email;

    //@Size(max = 12, message = "Too many digits! format: 000-555-1234")
    private String phone;

    public User(int userID, String name, String email, String phone) {
        //this.userID = userID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.userID = nextId;
        nextId++;
    }

    public User(){}

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID && getName().equals(user.getName()) && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, getName(), getEmail());
    }
}