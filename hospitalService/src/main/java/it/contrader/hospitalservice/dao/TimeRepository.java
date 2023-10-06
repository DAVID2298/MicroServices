package it.contrader.hospitalservice.dao;

import it.contrader.hospitalservice.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TimeRepository extends JpaRepository<Time, Long> {

    public List<Time> findAllByVisitaId(Long visitaId);

}
