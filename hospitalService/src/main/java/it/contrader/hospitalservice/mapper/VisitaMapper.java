package it.contrader.hospitalservice.mapper;

import it.contrader.hospitalservice.dto.VisitaDTO;
import it.contrader.hospitalservice.model.Visita;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitaMapper {

    Visita toVisita(VisitaDTO visitaDTO);

    VisitaDTO toVisitaDTO(Visita visita);

    List<Visita> toVisitaList(List<VisitaDTO> visitaDTOList);

    List<VisitaDTO> toDTOList(List<Visita> visitaList);
}
