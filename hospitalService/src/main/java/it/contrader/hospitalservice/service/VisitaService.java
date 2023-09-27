package it.contrader.hospitalservice.service;

import it.contrader.hospitalservice.dao.VisitaRepository;
import it.contrader.hospitalservice.mapper.VisitaMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitaService {

    @Autowired
    VisitaRepository repository;

    @Autowired
    VisitaMapper mapper;

    
}
