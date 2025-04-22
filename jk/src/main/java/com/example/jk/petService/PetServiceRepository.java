package com.example.jk.petService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetServiceRepository extends JpaRepository<PetService, Integer> {
    List<PetService> findByApprovedFalse();
    List<PetService> findByReportCountGreaterThan(int count);
    List<PetService> findByServiceType(String serviceType);
    Optional<PetService> findById(int id);


}
