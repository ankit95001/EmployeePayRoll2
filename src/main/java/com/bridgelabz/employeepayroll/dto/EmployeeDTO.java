package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]+$", message = "Name must start with a capital letter and contain only letters")
    private String name;

    @NotNull(message = "Salary is required")
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private Double salary;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date is required")
    @PastOrPresent(message = "Start Date must be today or in the past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;

    @NotBlank(message = "Profile picture cannot be empty")
    private String profilePic;

    @NotEmpty(message = "Department list cannot be empty")
    private List<String> department;
}