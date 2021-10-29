package org.launchcode.Songs4Soldiers.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String pwHash;

    //@NotBlank(message = "Email is required")
    @Email(message = "Invalid email. Try again.")
    @Size(min = 7, max = 55, message = "Email must be between 7 and 55 characters long")
    private String email;

    @Size(min = 10, max = 12, message = "Too many digits! format: 000-555-1234")
    private String phone;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.phone = phone;
    }

    public User(){}

    //Getters and setters

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
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
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
