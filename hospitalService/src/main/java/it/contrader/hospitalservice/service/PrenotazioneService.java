package it.contrader.hospitalservice.service;

import it.contrader.hospitalservice.dao.PrenotazioneRepository;
import it.contrader.hospitalservice.dto.PrenotazioneDTO;
import it.contrader.hospitalservice.mapper.PrenotazioneMapper;
import it.contrader.hospitalservice.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PrenotazioneService {

    @Autowired
    PrenotazioneMapper mapper;

    @Autowired
    PrenotazioneRepository repository;

    public PrenotazioneDTO insert(PrenotazioneDTO dto) {
        String numPrenotazione = rndNumPrenotazione();
        List<PrenotazioneDTO> tempList = getAll();
        for (PrenotazioneDTO prenotazione : tempList) {
            if (prenotazione.getNumPrenotazione().equals(numPrenotazione)){
                numPrenotazione = rndNumPrenotazione();
            }
        }
        dto.setNumPrenotazione(numPrenotazione);
        return mapper.toPrenotazioneDTO(repository.save(mapper.toPrenotazione(dto)));
    }

    public List<PrenotazioneDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public PrenotazioneDTO read(long id) {
        return mapper.toPrenotazioneDTO(repository.findById(id).get());
    }

    public PrenotazioneDTO update(PrenotazioneDTO dto) {
        return mapper.toPrenotazioneDTO(repository.save(mapper.toPrenotazione(dto)));
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public List<PrenotazioneDTO> getAllByUserId(Long userId) {
        return mapper.toDTOList((List<Prenotazione>) repository.findAllByUserId(userId));
    }

    private String rndNumPrenotazione(){
        Random rand = new Random();
        int bound = 999;
        Integer iRandom = rand.nextInt(bound);
        return iRandom.toString();

    }
}
