package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.RegisteredUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegUserRepository extends CrudRepository<RegisteredUser, Integer> {
        RegisteredUser findByUsername(String username);
}
