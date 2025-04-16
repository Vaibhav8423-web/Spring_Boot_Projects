package petistaan.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import petistaan.example.demo.dto.PetDTO;
import petistaan.example.demo.exception.PetNotFoundException;
import petistaan.example.demo.repository.PetRepository;
import petistaan.example.demo.service.PetService;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final String petNotFound;
    @Autowired
    public PetServiceImpl(@Value("${pet.not.found}") String petNotFound, PetRepository petRepository) {
        this.petNotFound = petNotFound;
        this.petRepository = petRepository;
    }

    @Override
    public PetDTO findPet(int petId) throws PetNotFoundException {
        return petRepository.findById(petId).orElseThrow(()-> new PetNotFoundException(String.format(petNotFound,petId)));
    }
}
