package it.contrader.hospitalservice.controller;

import it.contrader.hospitalservice.dao.VisitaImageRepository;
import it.contrader.hospitalservice.dto.VisitaImageDTO;
import it.contrader.hospitalservice.service.VisitaImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/visitaimage")
public class VisitaImageController {

    @Autowired
    private VisitaImageService service;

    @Autowired
    private VisitaImageRepository repository;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("visitaId") Long visitaId, @RequestParam("image")MultipartFile file) throws IOException {
        service.uploadImage(visitaId, file);
    }

    @GetMapping("/download")
    public ResponseEntity<List<VisitaImageDTO>> downloadImages(@RequestParam("id") Long id){
        List<VisitaImageDTO> visitaImageDTOS = service.download(id);
        return new ResponseEntity<>(visitaImageDTOS, HttpStatus.OK);
    }

    @GetMapping("/scarica")
    public ResponseEntity<byte[]> scarica(@RequestParam("visitaId") Long visitaId){
        byte[] image = service.downlo(visitaId);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @GetMapping("/scar")
    public ResponseEntity<List<String>> scar(@RequestParam("visitaId") Long visitaId){
        List<String> images = service.down(visitaId);
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("id") Long id){
        service.delete(id);
    }

    @PutMapping("/update")
    public VisitaImageDTO update(@RequestBody VisitaImageDTO visitaImageDTO){
        return service.update(visitaImageDTO);
    }
}
