package com.example.jk.petService;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetServiceRepository extends JpaRepository<PetService, Integer> {
    List<PetService> findByApproved(boolean approved);
    List<PetService> findByReportCountGreaterThan(int count);
}
