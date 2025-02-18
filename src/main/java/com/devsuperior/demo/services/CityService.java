package com.devsuperior.demo.services;


import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired

    private CityRepository cityRepository;

    public List<CityDTO> findAll() {
    List<City> cities = cityRepository.findAll(Sort.by("name"));
    return cities.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }

    public CityDTO insert(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        city = cityRepository.save(city);
        return new CityDTO(city);
    }


}
