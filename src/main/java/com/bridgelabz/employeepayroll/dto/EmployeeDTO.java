package com.bridgelabz.employeepayroll.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String name;
    private Double salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;
}

