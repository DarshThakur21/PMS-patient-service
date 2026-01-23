package com.pms.patient_service.exception;

public class PatientDoNotExist extends RuntimeException {
    public PatientDoNotExist(String message) {
        super(message);
    }
}
