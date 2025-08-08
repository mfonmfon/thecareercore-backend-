package com.thecareercore.thecareercore;

import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;
import com.thecareercore.thecareercore.services.interfaces.SponsorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SponsorServiceTest {

    @Autowired
    private SponsorService sponsorService;

    @Test
    public void testThatCanBecomeSponsors(){
        BecomeASponsorRequest becomeASponsor = new BecomeASponsorRequest();
        becomeASponsor.setFirstName("Moyo");
        becomeASponsor.setLastName("Mide");
        becomeASponsor.setPhoneNumber("09012233432");
        becomeASponsor.setCompanyEmail("moyo@gmail.com");
        becomeASponsor.setWhereYouHeardCareerCore("LinkedIn");
        becomeASponsor.setCompanyName("Cowrywise");
        becomeASponsor.setCompanyDescription("dgrgxth");
        BecomeASponsorResponse becomeASponsorResponse = sponsorService.becomeSponsor(becomeASponsor);
        assertThat(becomeASponsorResponse).isNotNull();
    }
}
