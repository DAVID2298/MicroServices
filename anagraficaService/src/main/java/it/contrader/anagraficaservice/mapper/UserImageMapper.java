package it.contrader.anagraficaservice.mapper;

import it.contrader.anagraficaservice.dto.UserImageDTO;
import it.contrader.anagraficaservice.model.UserImage;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserImageMapper {

    UserImage toUserImage(UserImageDTO userImageDTO);

    UserImageDTO toUserImageDTO(UserImage userImage);
}
