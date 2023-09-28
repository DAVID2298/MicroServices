package it.contrader.hospitalservice.service;

import it.contrader.hospitalservice.dao.VisitaImageRepository;
import it.contrader.hospitalservice.dto.VisitaImageDTO;
import it.contrader.hospitalservice.mapper.VisitaImageMapper;
import it.contrader.hospitalservice.model.VisitaImage;
import it.contrader.hospitalservice.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class VisitaImageService {

    @Autowired
    private VisitaImageRepository repository;

    @Autowired
    private VisitaImageMapper mapper;

    public VisitaImage uploadImage(Long visitaId, MultipartFile file) throws IOException {

        VisitaImageDTO visitaImageDTO = new VisitaImageDTO();
        visitaImageDTO.setImageData(ImageUtil.compressImage(file.getBytes()));

        visitaImageDTO.setVisitaId(visitaId);
        return repository.save(mapper.toVisitaImage(visitaImageDTO));
    }

    public byte[] downloadImage(Long id){
        Optional<VisitaImage> image = Optional.ofNullable(repository.findByVisitaId(id));
        return ImageUtil.decompressImage(image.get().getImageData());
    }

    public List<VisitaImageDTO> download(Long id){
        return mapper.toDTOList(repository.findAllByVisitaId(id));
    }

    public List<String> down(Long visitaId){
        List<byte[]> image = repository.findImageData(visitaId);
        List<String> img = new ArrayList<>();

        for (byte[] element :
                image) {
            byte[] encoded = ImageUtil.decompressImage(element);
            String encode = Base64.getEncoder().encodeToString(encoded);
            img.add(encode);
        }
        return img;
    }

    public byte[] downlo(Long visitaId){
        List<byte[]> image = repository.findImageData(visitaId);
        List<byte[]> img = new ArrayList<>();

        for ( byte[] element :
                image) {
            byte[] encoded = ImageUtil.decompressImage(element);
            byte[] encode = Base64.getEncoder().encode(encoded);
            img.add(encode);
        }
        return img.get(0);
    }

    public VisitaImageDTO update(VisitaImageDTO visitaImageDTO){
        return mapper.toVisitaImageDTO(repository.save(mapper.toVisitaImage(visitaImageDTO)));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
