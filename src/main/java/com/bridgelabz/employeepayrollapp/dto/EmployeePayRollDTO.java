package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayRollDTO {
	@NotEmpty(message = "Employee name cannot be null")
	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
	public String name;

	@Min(value = 500, message = "Minimum wage should be more than 500")
	public long salary;

	@Pattern(regexp = "Male|Female", message = "Gender needs to be male or female")
	public String gender;

	@JsonFormat(pattern = "dd MMM yyyy")
	@NotNull(message = "Start-Date should not be empty")
	@PastOrPresent(message = "startDate should be past or today's date")
	public LocalDate startDate;

	@NotBlank(message = "Note cannot be empty")
	public String note;

	@NotBlank(message = "Profie-Pic cannot be empty")
	public String profilePic;

	@NotNull(message = "Department should not be empty")
	public List<String> department;

	public EmployeePayRollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}
}
