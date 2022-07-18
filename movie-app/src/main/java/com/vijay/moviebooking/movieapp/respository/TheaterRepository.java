package com.vijay.moviebooking.movieapp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.moviebooking.movieapp.model.City;
import com.vijay.moviebooking.movieapp.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {

	public List<Theater> findByCity(City ID);
}
