package com.aps.restfulbackend.Services;

import com.aps.restfulbackend.Models.Representative;
import com.aps.restfulbackend.Repositories.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentativeService {

    @Autowired
    private RepresentativeRepository repRepository;

    public Representative getRepresentative(int id) {
        return repRepository.getRepresentativeById(id);
    }

}
