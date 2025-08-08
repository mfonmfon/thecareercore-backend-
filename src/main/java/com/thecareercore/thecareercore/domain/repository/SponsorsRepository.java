package com.thecareercore.thecareercore.domain.repository;

import com.thecareercore.thecareercore.domain.model.Sponsors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorsRepository extends JpaRepository<Sponsors, Long> {
    boolean existsByCompanyEmail(String email);

}
