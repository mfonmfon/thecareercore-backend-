package com.thecareercore.thecareercore.web;

import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.ApiResponse;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;
import com.thecareercore.thecareercore.services.interfaces.SponsorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sponsors")
public class SponsorsController {

    private final SponsorService sponsorService;

    public SponsorsController(SponsorService sponsorService) {
        this.sponsorService = sponsorService;
    }

    @PostMapping("/become-sponsor")
    public ResponseEntity<?> becomeSponsor(@RequestBody BecomeASponsorRequest becomeASponsorRequest){
        try {
            BecomeASponsorResponse becomeASponsorResponse = sponsorService.becomeSponsor(becomeASponsorRequest);
            return new ResponseEntity<>((new ApiResponse(true, becomeASponsorResponse)), HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>((new ApiResponse(false, exception.getMessage())), HttpStatus.BAD_REQUEST);
        }
    }
}
