package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

}
