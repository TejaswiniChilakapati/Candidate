package com.candidate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.candidate.entity.Candidate;

@Service
public interface CandidateService {

	public Candidate addCandidate(Candidate candidate) throws Exception;

	public Candidate updateCandidate(Candidate Candidate) throws Exception;

	public void deleteCandidateById(int Id);

	public Candidate getCandidateById(int Id) throws Exception;

	public List<Candidate> SortingCandidatesBasedOnConstituency() throws Exception;

	public List<Candidate> getAllCandidates() throws Exception;

	List<Candidate> getCandidatesBetweenIds(int range1, int range2) throws Exception;

}