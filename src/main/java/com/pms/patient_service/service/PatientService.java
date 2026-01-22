package com.pms.patient_service.service;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;

import java.util.List;

public interface PatientService {

    List<PatientResponseDto> getPatientsList();
    PatientResponseDto getPatient(String id);
    PatientResponseDto savePatient(PatientRequestDto patientRequestDto);
}
