package it.contrader.anagraficaservice.repository;

import it.contrader.anagraficaservice.model.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Long> {

    public UserImage findByUserId(Long id);

}
