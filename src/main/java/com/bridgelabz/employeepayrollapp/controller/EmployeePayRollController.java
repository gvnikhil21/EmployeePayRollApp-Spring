package com.bridgelabz.employeepayrollapp.controller;

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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<ResponseDTO> getEmployeePayRollData() {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, new EmployeePayRollDTO("Pankaj", 30000));
		ResponseDTO responseDTO = new ResponseDTO("Get Call Successful", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(@PathVariable("empId") int empId) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, new EmployeePayRollDTO("Pankaj", 30000));
		ResponseDTO responseDTO = new ResponseDTO("Get Call for Id " + empId + " Successful", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addEmployeePayRllData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, employeePayRollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Created Employee PayRoll Data Successfully", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDTO> updateEmployeepayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		EmployeePayRollData empData = null;
		empData = new EmployeePayRollData(1, employeePayRollDTO);
		ResponseDTO responseDTO = new ResponseDTO("Updated Employee PayRoll Data Successfully", empData);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayRollData(@PathVariable("empId") int empId) {
		ResponseDTO responseDTO = new ResponseDTO("Deleted Employee PayRoll Data Successfully", empId);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
	}
}
