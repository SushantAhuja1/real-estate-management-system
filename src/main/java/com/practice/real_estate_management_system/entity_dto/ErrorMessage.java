package com.practice.real_estate_management_system.entity_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private LocalDateTime timestamp;
    private int errorStatus;
    private String error;
    private String message;
    private String path;
}
