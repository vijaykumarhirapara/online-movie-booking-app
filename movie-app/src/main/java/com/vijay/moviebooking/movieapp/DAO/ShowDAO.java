package com.vijay.moviebooking.movieapp.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.moviebooking.movieapp.model.Movie;
import com.vijay.moviebooking.movieapp.model.Show;
import com.vijay.moviebooking.movieapp.respository.ShowRepository;

@Service
public class ShowDAO {

	@Autowired
	ShowRepository theShowRepository;
	
//	Save the show
	public Show save(Show show)
	{
		return theShowRepository.save(show);
	}
	
//	Fetch all show 
	public List<Show> fetchAllShow(){
		return theShowRepository.findAll();
		
	}
	
//	Fetch show by ID
	public Show fetchById(long Id) {
		return theShowRepository.findById(Id).get();
	}
	
//	Fetch show by Moive ID
	
	public List<Show> fetchByMovie(Movie m){
		return theShowRepository.findBytheMovie(m);
	}

	public void deleteShow(Show show) {
		theShowRepository.delete(show);
	}
}
