package com.vijay.moviebooking.movieapp.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.moviebooking.movieapp.model.Movie;
import com.vijay.moviebooking.movieapp.respository.MovieRepository;

@Service
public class MovieDAO {

	
	@Autowired
	MovieRepository theMoviewRepository;
	
//	Save the Movie
	public Movie save(Movie m) {
		return theMoviewRepository.save(m);
	}
	
//	FetchallMovie
	public List<Movie> getMovie(){
		return theMoviewRepository.findAll();
	}
	
//	Fetch movie by ID
	public Movie findOne(long ID){
		return theMoviewRepository.findById(ID).get();
	}
	
//	Delete Movie
	public void deleteMovie(Movie m) {
		theMoviewRepository.delete(m);
	}
	
//	get Movie list by theater ID
	public List<Object[]> getMovieByTheaterId(long ID){
		return theMoviewRepository.getMovieByTheateID(ID);
	}
	
}
