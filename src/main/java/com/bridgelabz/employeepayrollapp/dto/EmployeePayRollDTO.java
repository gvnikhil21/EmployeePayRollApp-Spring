package com.bridgelabz.employeepayrollapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class EmployeePayRollDTO {
	@NotEmpty(message = "Employee name cannot be null")
	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name is Invalid")
	public String name;
	@Min(value = 500, message = "Minimum wage should be more than 500")
	public long salary;

	public EmployeePayRollDTO(String name, long salary) {
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayRollDTO [name=" + name + ", salary=" + salary + "]";
	}
}
