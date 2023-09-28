package it.contrader.anagraficaservice.mapper;

import it.contrader.anagraficaservice.dto.OspedaleDTO;
import it.contrader.anagraficaservice.model.Ospedale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OspedaleMapper {

    Ospedale toOspedale(OspedaleDTO ospedaleDTO);

    OspedaleDTO toOspedaleDTO(Ospedale ospedale);
}
