package it.contrader.hospitalservice.mapper;

import it.contrader.hospitalservice.dto.TimeDTO;
import it.contrader.hospitalservice.model.Time;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimeMapper {

    Time toTime(TimeDTO timeDTO);

    TimeDTO toTimeDTO (Time time);

    List<Time> toTimeList (List<TimeDTO> timeDTOList);

    List<TimeDTO> toDTOList (List<Time> timeList);
}
