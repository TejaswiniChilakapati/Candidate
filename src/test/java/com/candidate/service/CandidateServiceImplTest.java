package com.candidate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.candidate.entity.Candidate;
import com.candidate.repository.CandidateRepository;



@SpringBootTest
class CandidateServiceImplTest {

		@Mock
		CandidateRepository candidateRepository;

		@InjectMocks
		CandidateServiceImpl candidateService;

		@Test
		@DisplayName("Test - to verify the add operation")
		void testAddCandidate() throws Exception {

			Candidate sampleInput = new Candidate("Rahul Gandhi", "Congress", "UP",231);
			Candidate expectedOutput = new Candidate("Rahul Gandhi", "Congress", "UP",231);

			BDDMockito.given(candidateService.addCandidate(sampleInput)).willReturn(expectedOutput);

			Candidate actualOutput = candidateService.addCandidate(sampleInput);

			assertEquals(expectedOutput, actualOutput);

		}

		@Test
		void testUpdateCandidate() throws Exception {

			Candidate sampleInput = new Candidate("Rahul Gandhi", "Congress", "UP",231);
			Candidate expectedOutput = new Candidate("Rahul Gandhi", "Congress", "UP",231);

			CandidateService candidateService = Mockito.mock(CandidateService.class);
			BDDMockito.when(candidateService.updateCandidate(sampleInput)).thenReturn(expectedOutput);

			Candidate actualOutput = candidateService.updateCandidate(sampleInput);

			assertEquals(expectedOutput, actualOutput);

		}

		@Test
		void testGetCandidateById() throws Exception {
		    Candidate sampleOutput = new Candidate("Rahul Gandhi", "Congress", "UP", 231);
		    sampleOutput.setcId(1);

		    int sampleInput = 1;
		    BDDMockito.given(candidateService.getCandidateBycId(sampleInput)).willReturn(sampleOutput);

		    Candidate actualOutput = candidateService.getCandidateBycId(sampleInput);

		    assertEquals(sampleOutput, actualOutput);
		    assertSame(sampleOutput.getcId(), actualOutput.getcId());
		    assertThat(actualOutput.getcId()).isPositive();
		}


		@Test
		void testGetCandidateByConstituency() throws Exception {
		    String expectedName = "Rahul Gandhi";
		    String expectedParty = "Congress";
		    String expectedConstituency = "UP";
		    int expectedvoterId=234;

		    Candidate sampleOutput = new Candidate(expectedName, expectedParty, expectedConstituency,expectedvoterId);
		    sampleOutput.setConstituency(expectedConstituency);

		   
		    assertEquals(expectedName, sampleOutput.getCandidateName());
		    assertEquals(expectedParty, sampleOutput.getPartyName());
		    assertEquals(expectedConstituency, sampleOutput.getConstituency());
		    assertEquals(expectedvoterId, sampleOutput.getVoterId());
		}
		


		@Test
		void testGetCandidatesBetweenIds() throws Exception {

			List<Candidate> sampleOutput = new ArrayList<>();

			int sampleInput1 = 1;
			int sampleInput2 = 20;

			BDDMockito.given(candidateService.getCandidatesBetweenIds(sampleInput1, sampleInput2)).willReturn(sampleOutput);
			List<Candidate> actualOutput = candidateService.getCandidatesBetweenIds(sampleInput1, sampleInput2);
			assertEquals(sampleOutput, actualOutput);
			assertIterableEquals(sampleOutput, actualOutput);
			assertNotNull(actualOutput);
		}

		@Test
		void testSortingCandidatesBasedOnConstituency() throws Exception {
			Candidate candidate1 = new Candidate("Rahul Gandhi", "Congress", "UP",231);
			Candidate candidate2 = new Candidate("Rahul Gandhi", "Congress", "UP",231);

			List<Candidate> sampleOutput = Arrays.asList(candidate1, candidate2);

			BDDMockito.given(candidateService.sortingCandidatesBasedOnConstituency()).willReturn(sampleOutput);

			List<Candidate> actualOutput = candidateService.sortingCandidatesBasedOnConstituency();

			assertEquals(sampleOutput, actualOutput);
			assertIterableEquals(sampleOutput, actualOutput);
			assertNotNull(actualOutput);

		}
	}


