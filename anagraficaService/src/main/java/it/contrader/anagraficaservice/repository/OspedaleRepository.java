package it.contrader.anagraficaservice.repository;

import it.contrader.anagraficaservice.model.Ospedale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OspedaleRepository extends JpaRepository<Ospedale, Long> {

    public Ospedale findByUserId(Long id);
}
