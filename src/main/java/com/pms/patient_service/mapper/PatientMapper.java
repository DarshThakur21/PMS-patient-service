package com.pms.patient_service.mapper;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;
import com.pms.patient_service.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientResponseDto toPatientResponseDto(Patient patient){
        PatientResponseDto patientResponseDto=new PatientResponseDto();
        patientResponseDto.setId(patient.getId().toString());
        patientResponseDto.setName(patient.getName());
        patientResponseDto.setEmail(patient.getEmail());
        patientResponseDto.setAddress(patient.getAddress());
        patientResponseDto.setDob(patientResponseDto.getDob());
        return patientResponseDto;
    }

    public static Patient toPatient(PatientRequestDto patientRequestDto){
        Patient patient=new Patient();
        patient.setName(patientRequestDto.getName());
        patient.setEmail(patientRequestDto.getEmail());
        patient.setAddress(patientRequestDto.getAddress());
        patient.setDob(LocalDate.parse(patientRequestDto.getDob()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDto.getRegisteredDate()));
        return patient;
    }

}
