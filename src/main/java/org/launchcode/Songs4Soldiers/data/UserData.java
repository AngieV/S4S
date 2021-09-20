package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static Map<Integer, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getUserID(), user);
    }

    public static User getById(Integer id) {
        return users.get(id);
    }
}
