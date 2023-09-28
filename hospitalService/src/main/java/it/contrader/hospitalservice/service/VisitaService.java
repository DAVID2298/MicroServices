package it.contrader.hospitalservice.service;

import it.contrader.hospitalservice.dao.VisitaRepository;
import it.contrader.hospitalservice.dto.VisitaDTO;
import it.contrader.hospitalservice.mapper.VisitaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    VisitaRepository repository;

    @Autowired
    VisitaMapper mapper;

    public VisitaDTO insert (VisitaDTO dto) {
        return mapper.toVisitaDTO(repository.save(mapper.toVisita(dto)));
    }

    public List<VisitaDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public VisitaDTO read(long id) {
        return mapper.toVisitaDTO(repository.findById(id).get());
    }

    public VisitaDTO update(VisitaDTO dto) {
        return mapper.toVisitaDTO(repository.save(mapper.toVisita(dto)));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
