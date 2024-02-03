package com.candidate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candidate.entity.Candidate;
import com.candidate.exception.NullException;

@Service
public interface CandidateService {

	public Candidate addCandidate(Candidate candidate) throws NullException;

	public Candidate updateCandidate(Candidate candidate) throws NullException;

	public void deleteCandidateById(int cId);

	public Candidate getCandidateBycId(int cId) throws NullException;

	public List<Candidate> sortingCandidatesBasedOnConstituency() throws NullException;

	public List<Candidate> getAllCandidates() throws NullException;

	 public List<Candidate> getCandidatesBetweenIds(int range1, int range2) throws NullException;
	
	  public List<Candidate> findBycId(Integer voterId);

}