package com.vijay.booking.controller.moviebookingapi.util;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DtoDomainMapper<dto, domain> {

	dto mapDomainToDto(domain d); 
	
	domain mapDtoToDomain(dto d);

	List<dto> mapDomainsToDtos(List<domain> domains);
}