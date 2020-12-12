package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;

public interface IEmployeePayRollService {
	List<EmployeePayRollData> getEmployeePayRollData();

	EmployeePayRollData getEmployeePayRollDataById(int empId);

	EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO);

	EmployeePayRollData updateEmployeePayRollData(int empId, EmployeePayRollDTO employeePayRollDTO);

	void delteEmployeePayRollData(int empId);
}
