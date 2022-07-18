package com.vijay.moviebooking.movieapp.DAO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.moviebooking.movieapp.model.City;
import com.vijay.moviebooking.movieapp.model.Theater;
import com.vijay.moviebooking.movieapp.respository.TheaterRepository;

@Service
public class TheaterDAO {
	
	@Autowired
	TheaterRepository theTheaterRepository;
	
	//Save Theater
	public Theater save(Theater t) {
		return theTheaterRepository.save(t);
	}
	
//	get all theater 
	public List<Theater> getTheater(){
		return theTheaterRepository.findAll();
	}
	
//	get Theater by ID
	
	public Theater findOne(long ID){
		
		return theTheaterRepository.findById(ID).get();
		
	}
	
//	Delete theater
	public void deleteTheater(Theater t) {
		theTheaterRepository.delete(t);
	}
	
//	Find theater by city ID
	public List<Theater> gettheaterByCityId(City c){
		return theTheaterRepository.findByCity(c);
	}
	
	public List<Theater> getTheaterByCityAndShowTimeAndMovieName(City c, String showtime, String moviename){
		List<Theater> theaters = theTheaterRepository.findByCity(c);
		return theaters.stream().filter(t ->t.getTheShow().stream().anyMatch(show -> show.getShow_time() == showtime || show.getTheMovie().get_name() == moviename)).collect(Collectors.toList());
	}

}
