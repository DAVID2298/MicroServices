package it.contrader.anagraficaservice.service;

import it.contrader.anagraficaservice.customException.AnagraficaNotFoundException;
import it.contrader.anagraficaservice.customException.UserIdNotFoundException;
import it.contrader.anagraficaservice.dto.OspedaleDTO;
import it.contrader.anagraficaservice.mapper.OspedaleMapper;
import it.contrader.anagraficaservice.repository.OspedaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OspedaleService {

    @Autowired
    private OspedaleRepository repository;

    @Autowired private OspedaleMapper mapper;

    public OspedaleDTO findByUserId(Long id) throws UserIdNotFoundException {
        if (repository.findByUserId(id) == null){
            throw new UserIdNotFoundException("Error: Ospedale non presente");
        }
        return mapper.toOspedaleDTO(repository.findByUserId(id));
    }

    public OspedaleDTO save(OspedaleDTO ospedaleDTO){
        return mapper.toOspedaleDTO(repository.save(mapper.toOspedale(ospedaleDTO)));
    }

    public void delete (Long id) {
        repository.deleteById(id);
    }

    public OspedaleDTO update (OspedaleDTO dto) {
        return mapper.toOspedaleDTO(repository.save(mapper.toOspedale(dto)));
    }

}
