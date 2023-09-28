package it.contrader.hospitalservice.service;

import it.contrader.hospitalservice.dao.TimeRepository;
import it.contrader.hospitalservice.dto.TimeDTO;
import it.contrader.hospitalservice.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    TimeMapper mapper;

    @Autowired
    TimeRepository repository;

    public TimeDTO insert (TimeDTO dto) {
        return mapper.toTimeDTO(repository.save(mapper.toTime(dto)));
    }

    public List<TimeDTO> getAll () {
        return mapper.toDTOList(repository.findAll());
    }

    public TimeDTO read(long id) {
        return mapper.toTimeDTO(repository.findById(id).get());
    }

    public TimeDTO update(TimeDTO dto) {
        return mapper.toTimeDTO(repository.save(mapper.toTime(dto)));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<TimeDTO> saveAll(List<TimeDTO> timeDTOList) {
        return mapper.toDTOList(repository.saveAll(mapper.toTimeList(timeDTOList)));
    }

    public List<TimeDTO> getAllByVisita(Long visitaId) {
        return mapper.toDTOList(repository.findAllByVisitaId(visitaId));
    }
}
