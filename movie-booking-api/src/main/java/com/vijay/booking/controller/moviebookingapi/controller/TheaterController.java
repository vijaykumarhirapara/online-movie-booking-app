package com.vijay.booking.controller.moviebookingapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.booking.controller.moviebookingapi.dto.CityDto;
import com.vijay.booking.controller.moviebookingapi.util.CityDtoMapper;
import com.vijay.booking.service.moviebookingservice.service.CityService;

@RestController
@RequestMapping("/api/v1")
public class TheaterController {

	@Autowired
	private CityService cityService;

	@Autowired
	private CityDtoMapper cityDtoMapper;

	@GetMapping("/hello")
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("Hello !!!");
	}

	@GetMapping(value = "/cities/{id}")
	public ResponseEntity<CityDto> getCity(@PathVariable Long id) {

		return ResponseEntity.ok(cityDtoMapper.mapDomainToDto(cityService.findById(id)));
	}

	@PostMapping(value = "/cities", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CityDto> createCity(@RequestBody @Valid CityDto cityDto) {

		return ResponseEntity.ok(cityDtoMapper.mapDomainToDto(cityService.save(cityDtoMapper.mapDtoToDomain(cityDto))));
	}

	@GetMapping(value = "/cities")
	public ResponseEntity<List<CityDto>> findAll() {

		return ResponseEntity.ok(cityDtoMapper.mapDomainsToDtos(cityService.findAll()));
	}

}
