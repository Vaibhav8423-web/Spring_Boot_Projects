package petistaan.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import petistaan.example.demo.dto.OwnerDTO;
import petistaan.example.demo.exception.DuplicateOwnerIdException;
import petistaan.example.demo.exception.OwnerNotFoundException;
import petistaan.example.demo.repository.OwnerRepository;
import petistaan.example.demo.service.OwnerService;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final String ownerAlreadyExist;
    private final String ownerNotFound;

    public OwnerServiceImpl(@Value("${owner.already.exist}") String ownerAlreadyExist, @Value("${owner.not.found}") String ownerNotFound, OwnerRepository ownerRepository) {
        this.ownerAlreadyExist=ownerAlreadyExist;
        this.ownerNotFound = ownerNotFound;
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerIdException {
        if(ownerRepository.findById(ownerDTO.getId()).isPresent()){
            throw new DuplicateOwnerIdException(String.format(ownerAlreadyExist,ownerDTO.getId()));
        }
        ownerRepository.save(ownerDTO);
    }

    @Override
    public OwnerDTO fetchOwner(int ownerId) throws OwnerNotFoundException {
        return ownerRepository.findById(ownerId).orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
    }

    @Override
    public void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException {
       OwnerDTO ownerDTO= ownerRepository.findById(ownerId).orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
       ownerDTO.getPetDTO().setName(petName);
    }

    @Override
    public void deleteOwner(int ownerId) throws OwnerNotFoundException {
        ownerRepository.findById(ownerId).orElseThrow(()->new OwnerNotFoundException(String.format(ownerNotFound,ownerId)));
        ownerRepository.deleteById(ownerId);
    }

    @Override
    public List<OwnerDTO> findAllOwners() {
        return ownerRepository.findAll();
    }
}
