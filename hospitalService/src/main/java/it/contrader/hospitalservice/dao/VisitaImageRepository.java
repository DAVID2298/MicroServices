package it.contrader.hospitalservice.dao;

import it.contrader.hospitalservice.model.VisitaImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface VisitaImageRepository extends JpaRepository<VisitaImage, Long> {

    VisitaImage findByVisitaId(Long visitaId);

    List<VisitaImage> findAllByVisitaId(Long visitaId);

    @Query(value = "SELECT imagedata FROM Visita_Image WHERE visita_id = :visitaId", nativeQuery = true)
    List<byte[]> findImageData(@Param("visitaId") Long visitaId);
}
