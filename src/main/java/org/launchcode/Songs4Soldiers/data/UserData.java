package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.User;
import org.launchcode.Songs4Soldiers.models.Veteran;
import org.launchcode.Songs4Soldiers.models.Volunteer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static Collection<User> getAll() {
        return users.values();
    }

    public static void add(User user) {
        users.put(user.getUserID(), user);
    }

    public static User getById(Integer id) {
        return users.get(id);
    }


    // store sub-user data
    private static final Map<Integer, Volunteer> volunteers = new HashMap<>();
    private static final Map<Integer, Veteran> veterans = new HashMap<>();

    //get sub-user id

    //get any user data by email
    public static User getUserByEmail(String email){
        return users.get(email);
    }
    public static Veteran getVetByEmail(String email){
        return veterans.get(email);
    }
    public static Volunteer getVolByEmail(String email) {
        return volunteers.get(email);
    }

    //add volunteers and vets

    //edit user info

    //verify user

    //reset password

    //get user purchase info

}
