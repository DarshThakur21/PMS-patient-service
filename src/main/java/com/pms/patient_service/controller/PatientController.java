package com.pms.patient_service.controller;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;
import com.pms.patient_service.service.PatientService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/all-patients")
    public ResponseEntity<List<PatientResponseDto>> getAllPatients(){
        List<PatientResponseDto> patientResponseDtosList=patientService.getPatientsList();
        return ResponseEntity.ok().body(patientResponseDtosList);
    }

    @PostMapping("/save")
    public ResponseEntity<PatientResponseDto> savePatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto=patientService.savePatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }

    @PutMapping("/edit-patient")
    public ResponseEntity<PatientResponseDto> editPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientResponseDto patientResponseDto=patientService.editPatient(patientRequestDto);
        return ResponseEntity.ok().body(patientResponseDto);
    }
}
