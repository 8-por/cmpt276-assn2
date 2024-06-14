package cmpt276.asn2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cmpt276.asn2.models.rectangle;

public interface rectangleRepository extends JpaRepository<rectangle, Long> {
    
}
