package com.demo.actuatorassignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit {
    private String endPoint;
    private Integer failure;
    private Integer success;
}
