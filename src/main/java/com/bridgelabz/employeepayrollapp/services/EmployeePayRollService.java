package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;

@Service
public class EmployeePayRollService implements IEmployeePayRollService {

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		List<EmployeePayRollData> empList = new ArrayList<>();
		empList.add(new EmployeePayRollData(1, new EmployeePayRollDTO("Pankaj", 30000)));
		return empList;
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int empId) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, new EmployeePayRollDTO("Pankaj", 30000));
		return empData;
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, employeePayRollDTO);
		return empData;
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, employeePayRollDTO);
		return empData;
	}

	@Override
	public void delteEmployeePayRollData(int empId) {
	}

}
