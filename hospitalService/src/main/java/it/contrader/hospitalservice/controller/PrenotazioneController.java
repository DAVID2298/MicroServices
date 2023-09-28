package it.contrader.hospitalservice.controller;

import it.contrader.hospitalservice.dto.PrenotazioneDTO;
import it.contrader.hospitalservice.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    @Autowired
    PrenotazioneService service;

    @GetMapping("/getall")
    public List<PrenotazioneDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/read")
    public PrenotazioneDTO read(@RequestParam("id") Long id) {
        return service.read(id);
    }

    @PostMapping("/insert")
    public PrenotazioneDTO insert(@RequestBody PrenotazioneDTO dto) {
        return service.insert(dto);
    }

    @PutMapping("/update")
    public PrenotazioneDTO update(@RequestBody PrenotazioneDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/getalladmin")
    public List<PrenotazioneDTO> getAllByUserId(@RequestParam("userId") Long userId) {
        return service.getAllByUserId(userId);
    }
}
