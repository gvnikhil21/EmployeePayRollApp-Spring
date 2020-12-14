package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;

import lombok.Data;

public @Data class EmployeePayRollData {
	private int employeeId;
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	private List<String> departments;

	public EmployeePayRollData() {
	}

	public EmployeePayRollData(int employeeId, EmployeePayRollDTO employeePayRollDTO) {
		this.employeeId = employeeId;
		this.name = employeePayRollDTO.name;
		this.salary = employeePayRollDTO.salary;
		this.gender = employeePayRollDTO.gender;
		this.note = employeePayRollDTO.note;
		this.startDate = employeePayRollDTO.startDate;
		this.profilePic = employeePayRollDTO.profilePic;
		this.departments = employeePayRollDTO.department;
	}
}
