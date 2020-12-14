package com.bridgelabz.employeepayrollapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayRollExceptionHandler {
	private static final String MESSAGE = "Exception while processing REST Request";

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(
			HttpMessageNotReadableException exception) {
		log.error("Invalid Date Format", exception);
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, "Should have date in the format dd MMM yyyy");
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMsg = errorList.stream().map(objError -> objError.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, errorMsg);
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeePayRollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayRollException(EmployeePayRollException exception) {
		ResponseDTO responseDTO = new ResponseDTO(MESSAGE, exception.getMessage());
		return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
	}

}
