package com.candidate.model;

import java.util.List;

import com.candidate.entity.Candidate;


public class RequiredResponse {
	
	private Candidate candidate;

    private List<Voter> voter;

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public List<Voter> getVoter() {
		return voter;
	}

	public void setVoter(List<Voter> voter) {
		this.voter = voter;
	}

   
}
