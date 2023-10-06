package it.contrader.authenticationservice.dto;

import it.contrader.authenticationservice.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDateTime creationDate;

    private Set<Role> roles;
}
