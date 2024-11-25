package com.aps.restfulbackend.Repositories;

import com.aps.restfulbackend.Models.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE job SET user_id = :in_user_id WHERE id = :job_id", nativeQuery = true)
    public int registerExistingJob(@Param("in_user_id") UUID in_user_id, @Param("job_id") String job_id);


    @Query(value = "SELECT email_auth FROM job WHERE id = :job_id", nativeQuery = true)
    public String getJobAuthEmail(@Param("job_id") String job_id);
}
