package org.launchcode.Songs4Soldiers.models;

import java.util.Date;

public class Volunteer extends User{

    private String vol_help;

    public Volunteer(int userID, String name, String email, String phone, String userType, String vol_help) {
        super(userID, name, email, phone, userType);
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
