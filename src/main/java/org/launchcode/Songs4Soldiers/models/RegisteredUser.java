package org.launchcode.Songs4Soldiers.models;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* public class RegisteredUser extends User { */
public class RegisteredUser extends AbstractEntity {

   /* @Id
    @GeneratedValue
    private int userId;*/

    @NotBlank(message = "Username is required")
    @NotNull
    //@Email(message = "Invalid username. Please enter a valid email.")
    @Size(min = 7, max = 55, message = "Username must be between 7 and 55 characters long")
    private String username;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public RegisteredUser(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }
}