package com.vijay.booking.repository.moviebookingrepository.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vijay.booking.repository.moviebookingrepository.entity.CityEntity;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Long> {

}
