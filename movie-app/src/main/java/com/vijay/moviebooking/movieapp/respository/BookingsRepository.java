package com.vijay.moviebooking.movieapp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.moviebooking.movieapp.model.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Long> {

}
