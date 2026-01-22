package com.pms.patient_service.repository;

import com.pms.patient_service.model.Patient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(@NotBlank @Email String email);

    Patient findByEmail(@NotBlank @Email String email);
}
