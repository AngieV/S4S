package org.launchcode.Songs4Soldiers.data;

import org.launchcode.Songs4Soldiers.models.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
}
