package it.contrader.hospitalservice.controller;

import it.contrader.hospitalservice.dto.VisitaDTO;
import it.contrader.hospitalservice.service.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    VisitaService service;

    @GetMapping("/getall")
    public List<VisitaDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public VisitaDTO insert (@RequestBody VisitaDTO dto) {
        return service.insert(dto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam("id") Long id) {
        service.delete(id);
    }

    @PutMapping("/update")
    public VisitaDTO update (@RequestBody VisitaDTO dto) {
        return service.update(dto);
    }

    @GetMapping("/read")
    public VisitaDTO read(@RequestParam("id") Long id) {
        return service.read(id);
    }
}
