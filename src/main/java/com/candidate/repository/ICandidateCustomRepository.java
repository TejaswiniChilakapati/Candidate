package com.candidate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.candidate.entity.Candidate;

@Repository

public interface ICandidateCustomRepository {

	public List<Candidate> getAllCandidatesByPartyName(String partyName) throws Exception;

	public Candidate getCandidateByCandidateName(String candidateName) throws Exception;

	public Candidate getCandidateById(int Id) throws Exception;

	public List<Candidate> getAllCandidatesByconstituency(String constituency) throws Exception;

	@Query("from Candidate where Id >= :range1 and Id <= :range2")
	public List<Candidate> getCandidatesBetweenIds(@Param("range1") int range1, @Param("range2") int range2)
			throws Exception;

}
