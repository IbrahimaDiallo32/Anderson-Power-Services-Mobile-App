package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.Ad;
import com.aps.restfulbackend.Models.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends CrudRepository<Ad, Integer> {

    @Query(value = "SELECT * FROM ad", nativeQuery = true)
    List<Ad> getAllAds();

}
