package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {


    @Autowired
    private EventRepository repository;



    public List<EventDTO> findAll() {
        List<Event> events = repository.findAll();
        return events.stream().map(event -> new EventDTO(event)).collect(Collectors.toList());
    }


    public EventDTO insert(EventDTO eventDTO) {
        Event entity = new Event();
        entity.setName(eventDTO.getName());
        entity.setDate(eventDTO.getDate());
        entity.setUrl(eventDTO.getUrl());
        entity.setCity(new City(eventDTO.getCityId(),null ));
        entity = repository.save(entity);
        return new EventDTO(entity);

    }







}
