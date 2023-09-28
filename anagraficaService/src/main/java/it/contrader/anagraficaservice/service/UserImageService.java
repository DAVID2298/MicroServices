package it.contrader.anagraficaservice.service;

import it.contrader.anagraficaservice.dto.UserImageDTO;
import it.contrader.anagraficaservice.mapper.UserImageMapper;
import it.contrader.anagraficaservice.model.UserImage;
import it.contrader.anagraficaservice.repository.OspedaleRepository;
import it.contrader.anagraficaservice.repository.UserImageRepository;
import it.contrader.anagraficaservice.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserImageService {

    @Autowired
    private UserImageRepository repository;

    @Autowired
    private UserImageMapper mapper;

    public UserImage uploadImage(Long userId, MultipartFile file) throws IOException {

        UserImageDTO userImageDTO = new UserImageDTO();
        userImageDTO.setImageData(ImageUtil.compressImage(file.getBytes()));

        userImageDTO.setUserId(userId);
        return repository.save(mapper.toUserImage(userImageDTO));
    }

    public  byte[] downloadImage(Long id){
        Optional<UserImage> image = Optional.ofNullable(repository.findByUserId(id));
        return ImageUtil.decompressImage(image.get().getImageData());
    }
}
