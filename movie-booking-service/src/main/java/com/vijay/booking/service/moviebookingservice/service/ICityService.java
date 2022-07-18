package com.vijay.booking.service.moviebookingservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vijay.booking.core.moviebookingcore.data.City;

@Service
public interface ICityService {

	City findById(Long id);

	City save(City city);

	List<City> findAll();
}
