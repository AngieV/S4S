package org.launchcode.Songs4Soldiers.models;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User extends AbstractEntity{

    @Id
    @GeneratedValue
    private int userId;

    @NotNull
    private String pwHash;

    //@NotBlank (message = "Name is required")
    private String name;

    //@NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    //@Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String email;

    @NotBlank(message = "Username is required")
    @Email(message = "Invalid username. Please enter a valid email.")
    @Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String username;

    @Size(min = 10, max = 12, message = "Too many digits! format: 000-555-1234")
    private String phone;

    //encode & store password hash
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(int userId, String name, String email, String username, String phone, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.pwHash = encoder.encode(password);
    }

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.userId = getUserID();
    }

    //Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public int getUserID() {
        return userId;
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
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserID() == user.getUserID() && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserID(), getEmail());
    }
}