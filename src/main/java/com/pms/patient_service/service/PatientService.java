package com.pms.patient_service.service;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;
import jakarta.validation.Valid;

import java.util.List;

public interface PatientService {

    public List<PatientResponseDto> getPatientsList();
    public PatientResponseDto getPatient(String id);
    public  PatientResponseDto savePatient(PatientRequestDto patientRequestDto);

    PatientResponseDto editPatient( PatientRequestDto patientRequestDto);
}
