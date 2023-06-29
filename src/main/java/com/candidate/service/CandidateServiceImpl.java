package com.candidate.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.entity.Candidate;
import com.candidate.repository.CandidateRepository;
import com.candidate.comparator.SortingCandidatesBasedOnConstituency;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	@Override
	public Candidate addCandidate(Candidate candidate) throws Exception {
		Candidate savedCandidate = candidateRepository.save(candidate);
		return savedCandidate;
	}

	@Override
	public Candidate updateCandidate(Candidate candidate) throws Exception {
		Candidate existingCandidate = candidateRepository.findById(candidate.getId()).orElse(null);
		existingCandidate.setCandidateName(candidate.getCandidateName());
		existingCandidate.setConstituency(candidate.getConstituency());
		return candidateRepository.save(existingCandidate);
	}

	@Override
	public Candidate getCandidateById(int Id) throws Exception {
		Candidate candidate = candidateRepository.getCandidateById(Id);
		return candidate;
	}

	@Override
	public List<Candidate> getCandidatesBetweenIds(int range1, int range2) throws Exception {
		return candidateRepository.getCandidatesBetweenIds(range1, range2);
	}

	@Override
	public List<Candidate> SortingCandidatesBasedOnConstituency() throws Exception {
		List<Candidate> list = candidateRepository.findAll();
		List<Candidate> allCandidates = new ArrayList<>();
		Collections.sort(list, new SortingCandidatesBasedOnConstituency());
		return list;

	}

	@Override
	public List<Candidate> getAllCandidates() throws Exception {

		List<Candidate> allCandidates = candidateRepository.findAll();
		return allCandidates;

	}

	@Override
	public void deleteCandidateById(int Id) {
		candidateRepository.deleteById(Id);

	}

}