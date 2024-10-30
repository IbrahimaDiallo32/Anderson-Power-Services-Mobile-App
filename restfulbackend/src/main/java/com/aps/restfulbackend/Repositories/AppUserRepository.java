package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, UUID> {

    @Query(value = "SELECT * FROM app_user WHERE email = :email", nativeQuery = true)
    AppUser getUserByEmail(@Param("email") String email);
}
