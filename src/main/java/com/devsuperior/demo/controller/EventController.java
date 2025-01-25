package com.devsuperior.demo.controller;


import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value ="/events" )
public class EventController {

  @Autowired
  private EventService service;



    @PostMapping
    ResponseEntity<EventDTO> insert(@RequestBody EventDTO eventDTO) {
        eventDTO = service.insert(eventDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(eventDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(eventDTO);
    }

    @GetMapping
    ResponseEntity<List<EventDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
