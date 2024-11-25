package com.aps.restfulbackend.Services;

import com.aps.restfulbackend.Models.AppUser;
import com.aps.restfulbackend.Models.Job;
import com.aps.restfulbackend.Repositories.AppUserRepository;
import com.aps.restfulbackend.Repositories.JobRepository;
import com.aps.restfulbackend.Services.Auth.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private AppUserService appUserService;

    public int RegisterJob(String job_id, UUID user_id) {

        AppUser appUser = appUserService.getUserByID(user_id);

        String jobEmailAuth = jobRepository.getJobAuthEmail(job_id);

        String appUserEmail = appUser.getEmail();

        // Check and make sure that user email and job auth email are the same.
        if (!appUserEmail.equals(jobEmailAuth)) {
            return -1;
        }

        return jobRepository.registerExistingJob(user_id, job_id);
    }
}
