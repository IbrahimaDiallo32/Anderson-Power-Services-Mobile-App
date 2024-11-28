package com.aps.restfulbackend.Services;

import com.aps.restfulbackend.Models.Ad;
import com.aps.restfulbackend.Models.Job;
import com.aps.restfulbackend.Repositories.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public List<String> getAdList() {
        List<Ad> ads = adRepository.getAllAds();

        ArrayList<String> adTexts = new ArrayList<>();

        for (Ad ad : ads) {
            adTexts.add(ad.getAd_text());
        }

        return adTexts;
    }

}
