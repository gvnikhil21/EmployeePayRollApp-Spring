package com.bridgelabz.employeepayrollapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayRollData;

public interface EmployeePayRollRepository extends JpaRepository<EmployeePayRollData, Integer> {

}
