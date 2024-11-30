package com.aps.restfulbackend.Controllers;

import com.aps.restfulbackend.Helpers.ExtractUserIDFromToken;
import com.aps.restfulbackend.Services.AdService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/ad")
public class AdController {

    @Autowired
    private ExtractUserIDFromToken extractUserIDFromToken;

    @Autowired
    private AdService adService;

    @GetMapping("/ad-list")
    public ResponseEntity adList(HttpServletRequest request) {

        UUID userId = extractUserIDFromToken.getUserIdFromToken(request);

        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User id is null!");
        }

        List<String> adTexts = adService.getAdList();

        return ResponseEntity.status(HttpStatus.OK).body(adTexts);

    }
}
