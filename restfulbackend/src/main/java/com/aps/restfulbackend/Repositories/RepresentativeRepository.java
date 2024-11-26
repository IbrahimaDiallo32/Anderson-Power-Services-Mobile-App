package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.Representative;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentativeRepository extends CrudRepository<Representative, Integer> {

    @Query(value = "SELECT * FROM representative WHERE id = :id", nativeQuery = true)
    public Representative getRepresentativeById(@Param("id") int id);

}
