package com.vijay.booking.controller.moviebookingapi.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.vijay.booking.controller.moviebookingapi.dto.CityDto;
import com.vijay.booking.core.moviebookingcore.data.City;

@Component
public class CityDtoMapper implements DtoDomainMapper<CityDto, City> {

	@Override
	public CityDto mapDomainToDto(City city) {
		CityDto cityDto = null;
		if (city != null) {
			cityDto = new CityDto();
			cityDto.setId(city.getId());
			cityDto.setName(city.getName());
			cityDto.setpincode(city.getpincode());
			cityDto.setstate(city.getstate());
		}
		return cityDto;
	}

	@Override
	public City mapDtoToDomain(CityDto cityDto) {
		City city = null;
		if (cityDto != null) {
			city = new City();
			city.setId(cityDto.getId());
			city.setName(cityDto.getName());
			city.setpincode(cityDto.getpincode());
			city.setstate(cityDto.getstate());
		}
		return city;
	}

	@Override
	public List<CityDto> mapDomainsToDtos(List<City> citys) {
		if (!CollectionUtils.isEmpty(citys)) {
			return citys.stream().map(this::mapDomainToDto).collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
