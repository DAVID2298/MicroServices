package it.contrader.hospitalservice.controller;

import it.contrader.hospitalservice.dto.TimeDTO;
import it.contrader.hospitalservice.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {

    @Autowired
    TimeService service;

    @GetMapping("/getall")
    public List<TimeDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/insert")
    public TimeDTO insert (@RequestBody TimeDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/update")
    public TimeDTO update (@RequestBody TimeDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestParam("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/read")
    public TimeDTO read (@RequestParam("id") Long id) {
        return service.read(id);
    }

    @PostMapping("/saveall")
    public List<TimeDTO> saveAll (@RequestBody List<TimeDTO> timeDTOList) {
        return service.saveAll(timeDTOList);
    }

    @GetMapping("/getbyvisita")
    public List<TimeDTO> getAllByVisitaId(@RequestParam("visitaId") Long visitaId) {
        return service.getAllByVisita(visitaId);
    }
}
