package it.contrader.anagraficaservice.service;

import it.contrader.anagraficaservice.customException.AnagraficaNotFoundException;
import it.contrader.anagraficaservice.customException.UserIdNotFoundException;
import it.contrader.anagraficaservice.dto.AnagraficaDTO;
import it.contrader.anagraficaservice.mapper.AnagraficaMapper;
import it.contrader.anagraficaservice.repository.AnagraficaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class AnagraficaService {
    @Autowired
    private AnagraficaRepository repository;

    @Autowired
    private AnagraficaMapper mapper;

    public AnagraficaDTO findByUserId(Long id) throws AnagraficaNotFoundException {
        if (repository.findByUserId(id) == null){
            throw new AnagraficaNotFoundException("Error: Anagrafica non presente");
        }
            return mapper.toAnagraficaDTO(repository.findByUserId(id));
    }

    public AnagraficaDTO save(AnagraficaDTO anagraficaDTO) {
        return mapper.toAnagraficaDTO(repository.save(mapper.toAnagrafica(anagraficaDTO)));
    }

    public List<AnagraficaDTO> findAll(){
        return mapper.toAnagraficaDTOList(repository.findAll());
    }
}

