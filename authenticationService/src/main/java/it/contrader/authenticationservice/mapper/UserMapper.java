package it.contrader.authenticationservice.mapper;

import it.contrader.authenticationservice.dto.UserDTO;
import it.contrader.authenticationservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")
public interface UserMapper {

    public User toUser(UserDTO userDTO);

    public UserDTO toUserDTO(User user);

    public List<UserDTO> toUserDTOList(List<User> user);

    public List<User> toUserList(List<UserDTO> userDTO);
}
