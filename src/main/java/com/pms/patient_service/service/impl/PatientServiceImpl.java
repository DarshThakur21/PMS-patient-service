package com.pms.patient_service.service.impl;

import com.pms.patient_service.dto.PatientRequestDto;
import com.pms.patient_service.dto.PatientResponseDto;
import com.pms.patient_service.exception.EmailAlreadyExistException;
import com.pms.patient_service.mapper.PatientMapper;
import com.pms.patient_service.model.Patient;
import com.pms.patient_service.repository.PatientRepository;
import com.pms.patient_service.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;


    public List<PatientResponseDto> getPatientsList(){
        List<Patient> patientList= patientRepository.findAll();
        List<PatientResponseDto> patientResponseDtos=patientList.stream()
                .map(PatientMapper::toPatientResponseDto).toList();
        return patientResponseDtos;
    }

    public PatientResponseDto getPatient(String id){
        UUID uid= UUID.fromString(id);
        Patient patient=patientRepository.findById(uid).orElseThrow();
        return PatientMapper.toPatientResponseDto(patient);
    }

    @Override
    public PatientResponseDto savePatient(PatientRequestDto patientRequestDto) {
        if(patientRepository.existByEmail(patientRequestDto.getEmail())){
            throw new EmailAlreadyExistException("Email alreayd present");
        }
        Patient patient=PatientMapper.toPatient(patientRequestDto);
        Patient savePatient=patientRepository.save(patient);
        return PatientMapper.toPatientResponseDto(savePatient);
    }
}
