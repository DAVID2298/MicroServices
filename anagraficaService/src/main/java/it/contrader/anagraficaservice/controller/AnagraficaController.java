package it.contrader.anagraficaservice.controller;

import it.contrader.anagraficaservice.customException.AnagraficaNotFoundException;
import it.contrader.anagraficaservice.customException.UserIdNotFoundException;
import it.contrader.anagraficaservice.dto.AnagraficaDTO;
import it.contrader.anagraficaservice.dto.Message;
import it.contrader.anagraficaservice.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anag")
public class AnagraficaController {

    @Autowired
    private AnagraficaService service;

    @PostMapping("/register")
    public AnagraficaDTO register(@RequestBody AnagraficaDTO anagraficaDTO) {
        return service.save(anagraficaDTO);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> findByUserId(@RequestParam Long id){
        try {
//            AnagraficaDTO anagraficaDTO = service.findByUserId(id);
            return ResponseEntity.ok(service.findByUserId(id));
        }catch (AnagraficaNotFoundException ex) {
            return ResponseEntity.badRequest().body(new Message(ex.getMessage()));

        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AnagraficaDTO>> getAll() {
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public AnagraficaDTO update(@RequestBody AnagraficaDTO anagraficaDTO){
        return service.save(anagraficaDTO);
    }


}
