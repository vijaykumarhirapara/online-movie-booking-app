package com.vijay.moviebooking.movieapp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vijay.moviebooking.movieapp.model.Movie;
import com.vijay.moviebooking.movieapp.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	
	public List<Show> findBytheMovie(Movie m);
}
