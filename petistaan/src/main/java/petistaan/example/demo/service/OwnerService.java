package petistaan.example.demo.service;

import petistaan.example.demo.dto.OwnerDTO;
import petistaan.example.demo.exception.DuplicateOwnerIdException;
import petistaan.example.demo.exception.OwnerNotFoundException;
import petistaan.example.demo.exception.PetNotFoundException;

import java.util.List;

public interface OwnerService {
    void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException;
    OwnerDTO fetchOwner(int ownerId) throws OwnerNotFoundException;
    void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;
    void deleteOwner(int ownerId) throws OwnerNotFoundException;
    List<OwnerDTO> findAllOwners();
}
