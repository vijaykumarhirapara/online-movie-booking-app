package com.vijay.booking.repository.moviebookingrepository.entity.utils;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface EntityDomainMapper<E, D> {

	D mapEntityToDomain(E e);

	E mapDomainToEntity(D d);

	List<D> mapEntitysToDomains(List<E> entitys);
}
