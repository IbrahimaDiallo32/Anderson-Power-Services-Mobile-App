package com.aps.restfulbackend.Controllers;

import com.aps.restfulbackend.Helpers.ExtractUserIDFromToken;
import com.aps.restfulbackend.Services.JobService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("api/v1/job")
public class JobController {

    @Autowired
    ExtractUserIDFromToken extractUserIDFromToken;

    @Autowired
    JobService jobService;

    @PostMapping("/register")
    public ResponseEntity registerJob(@RequestParam("job_id") String job_id,
                                      @RequestParam("auth_email") String auth_email,
                                      HttpServletRequest request)
    {
        UUID user_id = extractUserIDFromToken.getUserIdFromToken(request);

        if (user_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
        }

        if (job_id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Job ID was null!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Job registered successfully!");
    }
}
