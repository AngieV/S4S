package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.UserR;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Code provided by LaunchCode
 */

@Repository
public interface UserRRepository extends CrudRepository<UserR, Integer> {
    UserR findByUsername(String username);
}

