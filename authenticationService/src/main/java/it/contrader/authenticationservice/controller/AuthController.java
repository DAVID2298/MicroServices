package it.contrader.authenticationservice.controller;

import it.contrader.authenticationservice.customException.EmailAlreadyInUseException;
import it.contrader.authenticationservice.customException.UsernameAlreadyInUseException;
import it.contrader.authenticationservice.dto.LoginDTO;
import it.contrader.authenticationservice.dto.MessageResponse;
import it.contrader.authenticationservice.dto.SignupDTO;
import it.contrader.authenticationservice.dto.UserDTO;
import it.contrader.authenticationservice.security.JwtUtils;
import it.contrader.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok()
            .body(userService.login(loginDTO));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupDTO signUpRequest) {
        try {
            userService.registerUser(signUpRequest);
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } catch (UsernameAlreadyInUseException | EmailAlreadyInUseException ex) {
            return ResponseEntity.badRequest().body(new MessageResponse(ex.getMessage()));
        }
    }

    @PutMapping("/update")
    public UserDTO update(@RequestBody UserDTO userDTO){
        return userService.update(userDTO);
    }

    @GetMapping("/read")
    public UserDTO read(@RequestParam("id") long id) {
        return userService.read(id);
    }


    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id){
        userService.delete(id);
    }

    @GetMapping("/getall")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }



}
