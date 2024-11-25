package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.AppUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, UUID> {

    @Query(value = "SELECT * FROM app_user WHERE email = :email", nativeQuery = true)
    AppUser getUserByEmail(@Param("email") String email);

    @Query(value = "SELECT * FROM app_user WHERE user_id = :id", nativeQuery = true)
    AppUser getUserByID(@Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO app_user (first_name, last_name, email, password, phone) VALUES(:first_name, :last_name, :email, :password, :phone)", nativeQuery = true)
    int registerUser(@Param("first_name") String first_name,
                     @Param("last_name") String last_name,
                     @Param("email") String email,
                     @Param("password") String password,
                     @Param("phone") String phone);
}
