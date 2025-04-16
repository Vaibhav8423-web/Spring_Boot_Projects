package petistaan.example.demo.service;

import petistaan.example.demo.dto.PetDTO;
import petistaan.example.demo.exception.PetNotFoundException;

public interface PetService {
    PetDTO findPet(int petId) throws PetNotFoundException;
}
