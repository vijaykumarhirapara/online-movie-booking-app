package com.vijay.booking.repository.moviebookingrepository.entity.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.vijay.booking.core.moviebookingcore.data.City;
import com.vijay.booking.repository.moviebookingrepository.entity.CityEntity;

@Component
public class CityEntityMapper implements EntityDomainMapper<CityEntity, City>{

	@Override
	public City mapEntityToDomain(CityEntity cityEntity) {
		City city = null;
		if(cityEntity != null) {
			city = new City();
			city.setId(cityEntity.getId());
			city.setName(cityEntity.getName());
			city.setpincode(cityEntity.getpincode());
			city.setstate(cityEntity.getstate());
		}
		return city;
	}

	@Override
	public CityEntity mapDomainToEntity(City city) {
		CityEntity cityEntity = null;
		if(city != null) {
			cityEntity = new CityEntity();
			cityEntity.setId(city.getId());
			cityEntity.setName(city.getName());
			cityEntity.setpincode(city.getpincode());
			cityEntity.setstate(city.getstate());
		}
		return cityEntity;
	}
	
	@Override
	public List<City> mapEntitysToDomains(List<CityEntity> cityEntity) {
		if(!CollectionUtils.isEmpty(cityEntity)) {
			return cityEntity.stream().map(this :: mapEntityToDomain).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
