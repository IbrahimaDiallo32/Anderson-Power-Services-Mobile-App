package com.aps.restfulbackend.Services;

import com.aps.restfulbackend.Repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public int RegisterJob(String job_id, UUID user_id, String auth_email) {
        return 1;
    }
}
