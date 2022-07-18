package com.vijay.moviebooking.movieapp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.moviebooking.movieapp.model.Bookings;
import com.vijay.moviebooking.movieapp.respository.BookingsRepository;

@Service
public class BookingsDAO {

	@Autowired
	BookingsRepository theBookingsRepository;
	
//	Get the available seat for the movie 
	public Bookings getAvailableSeat(long showID) {
		return theBookingsRepository.findById(showID).get();
	}
	
//	Book the seat 
	public Bookings bookTheSeat(Bookings book) {
		return theBookingsRepository.save(book);
	}
	
}
