package com.example.jk.petService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceService {

    @Autowired
    private PetServiceRepository petServiceRepository;


    public PetService addService(PetService petService) {
        return petServiceRepository.save(petService);
    }

    public List<PetService> getAllServices() {
        return petServiceRepository.findAll();
    }

    public Optional<PetService> getServiceById(int id) {
        return petServiceRepository.findById(id);
    }

    public Optional<PetService> updateService(int id, PetService updatedService) {
        return petServiceRepository.findById(id).map(existingService -> {
            existingService.setDescription(updatedService.getDescription());
            existingService.setPrice(updatedService.getPrice());
            existingService.setAvailability(updatedService.getAvailability());
            return petServiceRepository.save(existingService);
        });
    }

    public boolean deleteService(int id) {
        if (petServiceRepository.existsById(id)) {
            petServiceRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<PetService> getReportedServices(int count) {
        return petServiceRepository.findByReportCountGreaterThan(count);
    }


    public List<PetService> getUnapprovedServices() {
        return petServiceRepository.findByApprovedFalse();
    }

    public boolean approveService(int id) {
        Optional<PetService> optionalService = petServiceRepository.findById(id);
        if (optionalService.isPresent()) {
            PetService service = optionalService.get();
            service.setApproved(true);
            petServiceRepository.save(service);
            return true;
        }
        return false;
    }



}


