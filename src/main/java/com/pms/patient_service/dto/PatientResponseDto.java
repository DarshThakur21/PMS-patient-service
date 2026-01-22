package com.pms.patient_service.dto;


import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
    private String id;
    private String name;
    private String email;
    private String address;
    private String dob;

}
