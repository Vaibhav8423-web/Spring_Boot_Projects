package petistaan.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import petistaan.example.demo.dto.PetDTO;

import java.util.Optional;

public interface PetRepository extends JpaRepository<PetDTO,Integer> {

}
