package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;

@Service
public class EmployeePayRollService implements IEmployeePayRollService {
	private List<EmployeePayRollData> empPayRollList = new ArrayList<>();

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		return empPayRollList;
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int empId) {
		return empPayRollList.get(empId - 1);
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(empPayRollList.size() + 1, employeePayRollDTO);
		empPayRollList.add(empData);
		return empData;
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(int empId, EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = this.getEmployeePayRollDataById(empId);
		empData.setName(employeePayRollDTO.name);
		empData.setSalary(employeePayRollDTO.salary);
		return empData;
	}

	@Override
	public void delteEmployeePayRollData(int empId) {
		empPayRollList.remove(empId - 1);
	}

}
