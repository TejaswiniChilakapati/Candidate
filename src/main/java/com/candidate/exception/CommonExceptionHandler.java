package com.candidate.exception;
import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AllExceptionDTO> candidate(javax.persistence.EntityNotFoundException e) {

		AllExceptionDTO dto = new AllExceptionDTO();

		dto.setMsg(e.getLocalizedMessage());
		dto.setCandidateInput(e.getLocalizedMessage().toString());
		dto.setDateAndTime(LocalDateTime.now().toString());

		return new ResponseEntity<AllExceptionDTO>(dto, HttpStatus.BAD_REQUEST);
	}

}
