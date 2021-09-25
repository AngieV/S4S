package org.launchcode.Songs4Soldiers.models;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
public class AuthenticateUser extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    public AuthenticateUser() {}

    public AuthenticateUser(String username, String password) {
        this.username = username;
        this.pwHash = password;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getUsername() {
        return username;
    }

}
