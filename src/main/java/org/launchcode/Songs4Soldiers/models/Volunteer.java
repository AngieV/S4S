package org.launchcode.Songs4Soldiers.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Volunteer extends User{

    @Size(max=500, message = "Description too long!")
    private String vol_help;

    public Volunteer(int userId, String name, String email, String username, String phone, String password, String vol_help) {
        super(userId, name, email, username, phone, password);
        this.vol_help = vol_help;
    }

    public Volunteer(){}

    public String getVol_help() {
        return vol_help;
    }

    public void setVol_help(String vol_help) {
        this.vol_help = vol_help;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "vol_help='" + vol_help + '\'' +
                '}';
    }
}
