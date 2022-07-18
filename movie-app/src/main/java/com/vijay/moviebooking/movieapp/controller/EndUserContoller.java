package com.vijay.moviebooking.movieapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.moviebooking.movieapp.DAO.BookingsDAO;
import com.vijay.moviebooking.movieapp.DAO.CityDAO;
import com.vijay.moviebooking.movieapp.DAO.MovieDAO;
import com.vijay.moviebooking.movieapp.DAO.ShowDAO;
import com.vijay.moviebooking.movieapp.DAO.TheaterDAO;
import com.vijay.moviebooking.movieapp.model.Bookings;
import com.vijay.moviebooking.movieapp.model.City;
import com.vijay.moviebooking.movieapp.model.Movie;
import com.vijay.moviebooking.movieapp.model.Show;
import com.vijay.moviebooking.movieapp.model.Theater;

@RestController
@RequestMapping("/user")
public class EndUserContoller {

	@Autowired
	CityDAO theCityDAO;
	
	@Autowired
	MovieDAO theMovieDAO;
	
	@Autowired
	TheaterDAO theTheaterDAO;
	
	@Autowired
	ShowDAO theShowDAO;
	
	@Autowired
	BookingsDAO theBookingsDAO;
	
//	Get the list of City where you can book the movie 
	
	@GetMapping("/city")
	public List<City> getAllCity(){
		
		return theCityDAO.getCity();
	}
	
	
//	GEt list of theater Available against a City
	
	@GetMapping("/{ID}/theater")
	public List<Theater> getTheaterInCity(@PathVariable(value = "ID") long ID){
		
		City theCity = theCityDAO.findOne(ID);
		
		return theTheaterDAO.gettheaterByCityId(theCity);
	}
	
//	Get Movie available on the theaters
	
	@GetMapping("/theater/{ID}/movie")
	public List<Object[]> getMovieByTheaterID(@PathVariable(value = "ID") long ID){
		
		return theMovieDAO.getMovieByTheaterId(ID);
	}
	
//	Get Available Show for a particular movie 
	
	@GetMapping("/movie/{id}/show")
	public List<Show> geShowByMovieId(@PathVariable(value ="id") long id){
		
		Movie theMovie = theMovieDAO.findOne(id);
	
		return theShowDAO.fetchByMovie(theMovie);
	}
	
//	Get the seat available for a particular Show using the show ID
	
	@GetMapping("/show/{id}")
	public Bookings getAvailableSeat(@PathVariable ( value = "id") long id)
	{
		return theBookingsDAO.getAvailableSeat(id);
	}
	
//	Book a Seat using the show id By passing the show POJO to the API 
	
	@PostMapping("show/{id}/bookings")
	public Bookings bookSeatForShow(@PathVariable (value = "id") long id, @Valid @RequestBody Bookings b)
	{
		return theBookingsDAO.bookTheSeat(b);
	}
	
	//get theaters by movie name and show time and by city id
	@GetMapping("/{ID}/theater")
	public List<Theater> getTheaterInCityByMovieNameandShowTime(@PathVariable(value = "ID") long ID, @RequestParam(value = "moviename") String moviename, @RequestParam(value = "showtime") String showtime){
		
		City theCity = theCityDAO.findOne(ID);
		
		return theTheaterDAO.getTheaterByCityAndShowTimeAndMovieName(theCity,showtime,moviename);
	}
	
}






