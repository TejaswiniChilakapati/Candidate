package com.candidate.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CandidateTest {

	@Test
	void testCandidate() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");

		// Assert the values returned by the getter methods

		assertEquals("Rahul Gandhi", candidate.getCandidateName());
		assertEquals("UP", candidate.getConstituency());
		assertEquals("Congress", candidate.getPartyName());

	}

	@Test
	void testGetId() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		int id = candidate.getId();
		equals(id);

	}

	@Test
	void testSetId() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		candidate.setId(2);
		equals(candidate.getId());

	}

	@Test
	void testGetCandidateName() {
		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		String candidateName = candidate.getCandidateName();
		assertEquals("Rahul Gandhi", candidateName);
	}

	@Test
	void testSetPartyName() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		candidate.setPartyName("CNG");
		assertEquals("CNG", candidate.getPartyName());

	}

	@Test
	void testGetConstituency() {
		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		String constituency = candidate.getConstituency();
		assertEquals("UP", constituency);

	}

	@Test
	void testSetConstituency() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP");
		candidate.setConstituency("CNG");
		assertEquals("CNG", candidate.getConstituency());

	}

	@Test
	void testToString() {

		String expectedString = "Candidate [ candidateName=Rahul Gandhi, partyName=Congress, constituency=UP]";
		equals(expectedString);

	}

}
