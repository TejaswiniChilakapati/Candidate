c                                                                                                                                                                                                                                                                                                                                                                jk iiiiiiii....package com.candidate.exception;

public class AllExceptionDTO {

	private String msg;

	private String candidateInput;

	private String dateAndTime;

	public String getMsg() {

		return msg;

	}

	public void setMsg(String msg) {

		this.msg = msg;

	}

	public String getCandidateInput() {

		return candidateInput;

	}

	public void setCandidateInput(String candidateInput) {

		this.candidateInput = candidateInput;

	}

	public String getDateAndTime() {

		return dateAndTime;

	}

	public void setDateAndTime(String dateAndTime) {

		this.dateAndTime = dateAndTime;

	}

	AllExceptionDTO() {

		super();



	}

	AllExceptionDTO(String msg, String candidateInput, String dateAndTime) {

		super();

		this.msg = msg;

		this.candidateInput = candidateInput;

		this.dateAndTime = dateAndTime;

	}


}
