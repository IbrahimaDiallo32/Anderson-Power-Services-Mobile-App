package com.aps.restfulbackend.Controllers;

import com.aps.restfulbackend.Dto.Responses.JobBundle;
import com.aps.restfulbackend.Helpers.ExtractUserIDFromToken;
import com.aps.restfulbackend.Services.JobService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;


@RestController
@RequestMapping("api/v1/job")
public class JobController {

    @Autowired
    private ExtractUserIDFromToken extractUserIDFromToken;

    @Autowired
    private JobService jobService;

    @PostMapping("/register")
    public ResponseEntity registerJob(@RequestParam("job_id") String job_id,
                                      HttpServletRequest request)
    {
        UUID user_id = extractUserIDFromToken.getUserIdFromToken(request);

        if (user_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
        }

        if (job_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Job ID was null!");
        }


        int result = jobService.RegisterJob(job_id, user_id);

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User email and job authentication email do not match!");
        }

        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Job registered successfully!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred while registering job!");
    }

    @PostMapping("/unregister")
    public ResponseEntity unregisterJob(@RequestParam("job_id") String job_id,
                                      HttpServletRequest request)
    {
        UUID user_id = extractUserIDFromToken.getUserIdFromToken(request);

        if (user_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
        }

        if (job_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Job ID was null!");
        }

        int result = jobService.unegisterJob(job_id, user_id);

        if (result == -1) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id and job's user id do not match!");
        }

        if (result == 1) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Job unregistered successfully!");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred while unregistering job!");
    }

    @GetMapping("/get-user-jobs")
    public ResponseEntity getUserJobs(HttpServletRequest request) {

        UUID user_id = extractUserIDFromToken.getUserIdFromToken(request);

        if (user_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
        }

        ArrayList<JobBundle> response = jobService.getUserJobBundles(user_id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
