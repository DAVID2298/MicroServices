package it.contrader.hospitalservice.mapper;

import it.contrader.hospitalservice.dto.PrenotazioneDTO;
import it.contrader.hospitalservice.model.Prenotazione;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrenotazioneMapper {

    Prenotazione toPrenotazione (PrenotazioneDTO prenotazioneDTO);

    PrenotazioneDTO toPrenotazioneDTO (Prenotazione prenotazione);

    List<Prenotazione> toPrenotazione (List<PrenotazioneDTO> prenotazioneDTOList);

    List<PrenotazioneDTO> toDTOList (List<Prenotazione> prenotazioneList);
}
