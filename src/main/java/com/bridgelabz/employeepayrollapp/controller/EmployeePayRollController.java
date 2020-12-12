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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayRollController {

	@RequestMapping(value = { "", "/", "/get" })
	public ResponseEntity<String> getEmployeePayRollData() {
		return new ResponseEntity<>("Get Call Success", HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayRollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<>("Get Call Success for id: " + empId, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addEmployeePayRllData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		return new ResponseEntity<>("Created Employee PayRoll Data for: " + employeePayRollDTO, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeepayRollData(@RequestBody EmployeePayRollDTO employeePayRollDTO) {
		return new ResponseEntity<>("Updated Employee PayRoll Data for: " + employeePayRollDTO, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayRollData(@PathVariable("empId") int empId) {
		return new ResponseEntity<>("Delete Call Success for id : " + empId, HttpStatus.OK);
	}
}
