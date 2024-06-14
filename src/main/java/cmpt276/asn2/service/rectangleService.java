package cmpt276.asn2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cmpt276.asn2.models.rectangle;
import cmpt276.asn2.repository.rectangleRepository;

@Service
public class rectangleService {
    @Autowired
    private rectangleRepository rectangleRepository;

    public List<rectangle> getAllRectangles() {
        return rectangleRepository.findAll();
    }

    public Optional<rectangle> getRectangle(Long id) {
        return rectangleRepository.findById(id);
    }


    public rectangle updateRectangle(rectangle rectangle) {
        return rectangleRepository.save(rectangle);
    }

    public void deleteRectangle(Long id) {
        rectangleRepository.deleteById(id);
    }
}

