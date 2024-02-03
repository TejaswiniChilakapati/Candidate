package com.candidate.service;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.entity.Candidate;
import com.candidate.exception.NullException;
import com.candidate.repository.CandidateRepository;
import com.candidate.comparator.SortingCandidatesBasedOnConstituency;

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	
	
	@Override
	public Candidate addCandidate(Candidate candidate) throws NullException {
	    return candidateRepository.save(candidate);
	}


	@Override
	public Candidate updateCandidate(Candidate candidate) throws NullException {
	    Candidate existingCandidate = candidateRepository.findById(candidate.getcId()).orElseThrow(() -> new NullException("Candidate not found"));
	    existingCandidate.setCandidateName(candidate.getCandidateName());
	    existingCandidate.setConstituency(candidate.getConstituency());
	    return candidateRepository.save(existingCandidate);
	}


	@Override
	public Candidate getCandidateBycId(int cId) throws NullException {
	    return candidateRepository.getCandidateBycId(cId);
	}


	@Override
	public List<Candidate> getCandidatesBetweenIds(int range1, int range2) throws NullException {
		return candidateRepository.getCandidatesBetweenIds(range1, range2);
	}

	@Override
	public List<Candidate> sortingCandidatesBasedOnConstituency() throws NullException {
		List<Candidate> list = candidateRepository.findAll();
		Collections.sort(list, new SortingCandidatesBasedOnConstituency());
		return list;

	}

	@Override
	public List<Candidate> getAllCandidates() throws NullException {
	    return candidateRepository.findAll();
	}

	@Override
	public void deleteCandidateById(int cId) {
		candidateRepository.deleteById(cId);

	}
	@Override
	public List<Candidate> findBycId(Integer voterId) {
	    List<Candidate> candidates = candidateRepository.findBycId(voterId);
	    if (candidates.isEmpty()) {
	        return Collections.emptyList();
	    }
	    return candidates;
	}

	
	

	

}