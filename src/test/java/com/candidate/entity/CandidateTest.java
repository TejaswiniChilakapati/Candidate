package com.candidate.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CandidateTest {

	@Test
	void testCandidate() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);

		// Assert the values returned by the getter methods

		assertEquals("Rahul Gandhi", candidate.getCandidateName());
		assertEquals("UP", candidate.getConstituency());
		assertEquals("Congress", candidate.getPartyName());

	}

	@Test
	void testGetcId() {
		Candidate candidate = new Candidate();
		candidate.setcId(1);
		assertEquals(1, candidate.getcId());

	}

	@Test
	void testSetcId() {
		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		candidate.setcId(2);
		Assertions.assertEquals(2, candidate.getcId());
	}

	@Test
	void testGetCandidateName() {
		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		String candidateName = candidate.getCandidateName();
		assertEquals("Rahul Gandhi", candidateName);
	}

	@Test
	void testSetPartyName() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		candidate.setPartyName("CNG");
		assertEquals("CNG", candidate.getPartyName());

	}

	@Test
	void testGetConstituency() {
		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		String constituency = candidate.getConstituency();
		assertEquals("UP", constituency);

	}

	@Test
	void testSetConstituency() {

		Candidate candidate = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		candidate.setConstituency("CNG");
		assertEquals("CNG", candidate.getConstituency());

	}

	@Test
	void setCandidateName_ValidName_SetsCandidateName() {
		Candidate candidate = new Candidate();
		String candidateName = "John Doe";
		candidate.setCandidateName(candidateName);
		assertEquals(candidateName, candidate.getCandidateName());
	}
	@Test
	void testToString() {
	    Candidate candidate = new Candidate();
	    candidate.setVoterId(1);
	    candidate.setCandidateName("Rahul Gandhi");
	    candidate.setConstituency("UP");
	    candidate.setPartyName("congress");
	    candidate.setcId(30);

	    String expectedString = "Candidate [cId=30, candidateName=Rahul Gandhi, partyName=congress, constituency=UP, voterId=1]";
	    assertEquals(expectedString, candidate.toString());
	}

}
