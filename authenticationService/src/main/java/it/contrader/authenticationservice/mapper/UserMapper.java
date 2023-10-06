package it.contrader.authenticationservice.mapper;

import it.contrader.authenticationservice.dto.UserDTO;
import it.contrader.authenticationservice.model.User;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface UserMapper {

    public User toUser(UserDTO userDTO);

    public UserDTO toUserDTO(User user);
}
