package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.exceptions.EmployeePayRollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayRollService implements IEmployeePayRollService {

	@Autowired
	private EmployeePayRollRepository employeeRepository;

	private AtomicInteger counter = new AtomicInteger();

	@Override
	public List<EmployeePayRollData> getEmployeePayRollData() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeePayRollData getEmployeePayRollDataById(int empId) {
		EmployeePayRollData empData = null;
		Optional<EmployeePayRollData> empGetData = employeeRepository.findById(empId);
		if (empGetData.isPresent())
			empData = empGetData.get();
		else
			throw new EmployeePayRollException("Employee Not Found");
		return empData;
	}

	@Override
	public EmployeePayRollData createEmployeePayRollData(EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(counter.incrementAndGet(), employeePayRollDTO);
		log.debug("Emp Data: " + empData.toString());
		return employeeRepository.save(empData);
	}

	@Override
	public EmployeePayRollData updateEmployeePayRollData(int empId, EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = this.getEmployeePayRollDataById(empId);
		if (!empData.getName().equals(employeePayRollDTO.name))
			empData.setName(employeePayRollDTO.name);
		if (empData.getSalary() != employeePayRollDTO.salary)
			empData.setSalary(employeePayRollDTO.salary);
		if (!empData.getGender().equals(employeePayRollDTO.gender))
			empData.setGender(employeePayRollDTO.gender);
		if (!empData.getNote().equals(employeePayRollDTO.note))
			empData.setNote(employeePayRollDTO.note);
		if (!empData.getProfilePic().equals(employeePayRollDTO.profilePic))
			empData.setProfilePic(employeePayRollDTO.profilePic);
		if (!empData.getDepartments().equals(employeePayRollDTO.department))
			empData.setDepartments(employeePayRollDTO.department);
		if (!empData.getStartDate().equals(employeePayRollDTO.startDate))
			empData.setStartDate(employeePayRollDTO.startDate);
		return employeeRepository.save(new EmployeePayRollData(empId, employeePayRollDTO));
	}

	@Override
	public void deleteEmployeePayRollData(int empId) {
		EmployeePayRollData empData = this.getEmployeePayRollDataById(empId);
		employeeRepository.delete(empData);
	}

}
