package it.contrader.hospitalservice.mapper;

import it.contrader.hospitalservice.dto.VisitaImageDTO;
import it.contrader.hospitalservice.model.VisitaImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VisitaImageMapper {

    VisitaImage toVisitaImage (VisitaImageDTO visitaImageDTO);

    VisitaImageDTO toVisitaImageDTO (VisitaImage visitaImage);

    List<VisitaImage> toVisitaImageList (List<VisitaImageDTO> visitaImageDTOList);

    List<VisitaImageDTO> toDTOList (List<VisitaImage> visitaImageList);
}
