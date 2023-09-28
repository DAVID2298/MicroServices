package it.contrader.anagraficaservice.controller;

import com.netflix.discovery.converters.Auto;
import it.contrader.anagraficaservice.customException.UserIdNotFoundException;
import it.contrader.anagraficaservice.dto.Message;
import it.contrader.anagraficaservice.dto.OspedaleDTO;
import it.contrader.anagraficaservice.service.OspedaleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ospedale")
public class OspedaleController {

    @Autowired
    private OspedaleService service;

    @PostMapping("/registerOspedale")
    public OspedaleDTO register(@RequestBody OspedaleDTO ospedaleDTO){
        return service.save(ospedaleDTO);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<?> findByUserId(@RequestParam Long id){
        try {
            return ResponseEntity.ok(service.findByUserId(id));
        } catch (UserIdNotFoundException e){
            return ResponseEntity.badRequest().body(new Message(e.getMessage()));
        }
    }

    @PutMapping("/update")
    public OspedaleDTO update (@RequestBody OspedaleDTO ospedaleDTO) {
        return service.update(ospedaleDTO);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam("id") Long id) {
        service.delete(id);
    }
}
