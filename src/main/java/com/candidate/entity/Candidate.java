
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
	private int cId;
	private String candidateName;
	private String partyName;
	private String constituency;
	private int voterId;
	public Candidate() {
		super();
		
	}
	public Candidate( String candidateName, String partyName, String constituency, int voterId) {
		super();
		this.candidateName = candidateName;
		this.partyName = partyName;
		this.constituency = constituency;
		this.voterId = voterId;
	}
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
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
	public int getVoterId() {
		return voterId;
	}                                                                       
	public void setVoterId(int voterId) {                                                                                                    n                            
		this.voterId = voterId;
	}
	@Override
	public String toString() {
		return "Candidate [cId=" + cId + " , candidateName=" + candidateName + ", partyName=" + partyName
				+ ", constituency=" + constituency + ", voterId=" + voterId + "]";
	}
	
	
}
	