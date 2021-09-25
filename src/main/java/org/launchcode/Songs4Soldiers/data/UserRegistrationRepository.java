package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.User_Registered;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends CrudRepository<User_Registered, Integer> {
    User_Registered findByUsername(String username);
}

