package com.pms.patient_service.controller;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;
import com.pms.patient_service.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@Tag(name="Patient Controller", description = "API for managing controllers")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all-patients")
    @Operation(summary = "Get all patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){
        List<PatientResponseDto> patientResponseDtosList=patientService.getPatientsList();
        return ResponseEntity.ok().body(patientResponseDtosList);
    }

    @PostMapping("/save")
    @Operation(summary = "create patients")
    public ResponseEntity<PatientResponseDto> savePatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto=patientService.savePatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @PutMapping("/edit-patient")
    @Operation(summary = "Edit patients")
    public ResponseEntity<PatientResponseDto> editPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto=patientService.editPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @DeleteMapping("/delete-patient/{id}")
    @Operation(summary = "Delete patients")
    public ResponseEntity<?> deletePatient(@PathVariable String id){
         patientService.deleteById(id);
        return ResponseEntity.ok().body("Deleted success");
    }

}
