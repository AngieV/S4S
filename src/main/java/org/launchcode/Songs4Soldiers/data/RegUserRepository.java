package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.RegisteredUser;
import org.launchcode.Songs4Soldiers.models.User;
import org.springframework.data.repository.CrudRepository;

public interface RegUserRepository extends CrudRepository<RegisteredUser, Integer> {
    User findByUsername(String username);
}
