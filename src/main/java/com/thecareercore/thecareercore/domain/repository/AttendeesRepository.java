package com.thecareercore.thecareercore.domain.repository;
import com.thecareercore.thecareercore.domain.model.Attendees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeesRepository extends JpaRepository<Attendees, Long> {

//    boolean findByEmail(String email);

    boolean existsByEmail(String email);
}

