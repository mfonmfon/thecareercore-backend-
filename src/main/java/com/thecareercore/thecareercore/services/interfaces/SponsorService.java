package com.thecareercore.thecareercore.services.interfaces;

import com.thecareercore.thecareercore.dtos.requests.BecomeASponsorRequest;
import com.thecareercore.thecareercore.dtos.responses.BecomeASponsorResponse;

public interface SponsorService {
    BecomeASponsorResponse becomeSponsor(BecomeASponsorRequest becomeASponsor);
}
