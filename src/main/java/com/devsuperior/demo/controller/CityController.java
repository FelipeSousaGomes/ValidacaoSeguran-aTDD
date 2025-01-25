package com.devsuperior.demo.controller;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import com.devsuperior.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService service;


    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        List<CityDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);
    }





}
