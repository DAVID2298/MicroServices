package it.contrader.anagraficaservice.repository;

import it.contrader.anagraficaservice.dto.AnagraficaDTO;
import it.contrader.anagraficaservice.model.Anagrafica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnagraficaRepository extends JpaRepository<Anagrafica, Long> {

    public Anagrafica findByUserId(Long id);

    public List<Anagrafica> findAll();

}
