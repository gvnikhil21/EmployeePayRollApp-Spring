package com.bridgelabz.employeepayrollapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;

import lombok.Data;

@Entity
@Table(name = "employee_payroll")
public @Data class EmployeePayRollData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "name")
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;

	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
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
