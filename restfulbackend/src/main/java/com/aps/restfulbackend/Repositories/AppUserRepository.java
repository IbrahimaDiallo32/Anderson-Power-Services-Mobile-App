package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AppUserRepository extends CrudRepository<AppUser, UUID> {

}
