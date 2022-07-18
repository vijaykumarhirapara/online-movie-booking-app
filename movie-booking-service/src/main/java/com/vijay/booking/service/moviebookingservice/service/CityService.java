package com.vijay.booking.service.moviebookingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.booking.core.moviebookingcore.data.City;
import com.vijay.booking.core.moviebookingcore.exception.CityNotFoundException;
import com.vijay.booking.core.moviebookingcore.exception.NoDataFoundException;
import com.vijay.booking.repository.moviebookingrepository.entity.CityEntity;
import com.vijay.booking.repository.moviebookingrepository.entity.utils.CityEntityMapper;
import com.vijay.booking.repository.moviebookingrepository.repository.CityRepository;

@Service
public class CityService implements ICityService {

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CityEntityMapper cityEntityMapper;

	@Override
	public City findById(Long id) {

		return cityEntityMapper
				.mapEntityToDomain(cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException(id)));
	}

	@Override
	public City save(City city) {

		return cityEntityMapper.mapEntityToDomain(cityRepository.save(cityEntityMapper.mapDomainToEntity(city)));
	}

	@Override
	public List<City> findAll() {
		List<City> cities = cityEntityMapper.mapEntitysToDomains((List<CityEntity>) cityRepository.findAll());

		if (cities.isEmpty()) {

			throw new NoDataFoundException();
		}

		return cities;
	}
}