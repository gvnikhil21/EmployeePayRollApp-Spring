package com.bridgelabz.employeepayrollapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayRollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayRollService;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {

	@Autowired
	private IEmployeePayRollService employeePayRollService;

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayRollData() {
		List<EmployeePayRollData> empList = null;
		empList = employeePayRollService.getEmployeePayRollData();
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empList);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(@PathVariable("empId") int empId) {
		EmployeePayRollData empData = null;
		empData = employeePayRollService.getEmployeePayRollDataById(empId);
		ResponseDTO responseDTO = new ResponseDTO("Get Call for Id " + empId + " Successful", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addEmployeePayRllData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = employeePayRollService.createEmployeePayRollData(employeePayRollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee PayRoll Data Successfully", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeepayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = employeePayRollService.updateEmployeePayRollData(employeePayRollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee PayRoll Data Successfully", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayRollData(@PathVariable("empId") int empId) {
		employeePayRollService.delteEmployeePayRollData(empId);
		ResponseDTO responseDTO = new ResponseDTO("Deleted Employee PayRoll Data Successfully", empId);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
