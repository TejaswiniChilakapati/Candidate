
package com.candidate.entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;



@Entity

@Table(name = "CandidateDetails")

public class Candidate {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;

	// @NotBlank(message = "candidateName should not be null")

	private String candidateName;

	// @NotBlank(message = "partyName should not be null")

	private String partyName;

	private String constituency;

	public Candidate() {

		super();

	}

	public Candidate(String candidateName, String partyName, String constituency) {

		super();

		this.candidateName = candidateName;

		this.partyName = partyName;

		this.constituency = constituency;

	}

	public int getId() {

		return id;

	}

	public void setId(int id) {

		this.id = id;

	}

	public String getCandidateName() {

		return candidateName;

	}

	public void setCandidateName(String candidateName) {

		this.candidateName = candidateName;

	}

	public String getPartyName() {

		return partyName;

	}

	public void setPartyName(String partyName) {

		this.partyName = partyName;

	}

	public String getConstituency() {

		return constituency;

	}

	public void setConstituency(String constituency) {

		this.constituency = constituency;

	}

	@Override

	public String toString() {

		return "Candidate [id=" + id + ", candidateName=" + candidateName + ", partyName=" + partyName

				+ ", constituency=" + constituency + "]";

	}

}
