package org.launchcode.Songs4Soldiers.models;

import org.dom4j.tree.AbstractEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/*
 * Code provided by LaunchCode
 */

@Entity
public class UserR extends AbstractEntity {

        @NotNull
        private String username;

        @NotNull
        private String pwHash;

        public UserR() {}

        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        public UserR(String username, String password) {
                this.username = username;
                this.pwHash = encoder.encode(password);
            }

            public String getUsername() {
                return username;
            }

        public boolean isMatchingPassword(String password) {
            return encoder.matches(password, pwHash);
        }

    }
