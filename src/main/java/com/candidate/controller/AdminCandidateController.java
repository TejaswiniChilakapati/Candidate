package com.candidate.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.candidate.entity.Candidate;
import com.candidate.exception.NullException;
import com.candidate.model.RequiredResponse;
import com.candidate.model.Voter;
import com.candidate.pojo.AddCandidateRequest;
import com.candidate.pojo.UpdateCandidateRequest;
import com.candidate.repository.CandidateRepository;
import com.candidate.service.CandidateService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminCandidateController {
	@Autowired
	CandidateService candidateService;
	@Autowired
	CandidateRepository candidateRepository;

	@Autowired
	RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(AdminCandidateController.class);

	// localhost:8888/admin/addCandidate
	@PostMapping("/addCandidate")
	public ResponseEntity<Candidate> addCandidate(@RequestBody AddCandidateRequest request) throws NullException {
		Candidate candidate = new Candidate();
		candidate.setCandidateName(request.getCandidateName());
		candidate.setPartyName(request.getPartyName());
		candidate.setConstituency(request.getConstituency());
		candidate.setVoterId(request.getVoterId());

		Candidate savedCandidate = candidateService.addCandidate(candidate);
		return new ResponseEntity<>(savedCandidate, HttpStatus.CREATED);
	}
    //localhost:8088/admin/allCandidates
	@GetMapping("/allCandidates")
	public List<Candidate> getAllCandidates() {
		List<Candidate> allCandidates = new ArrayList<>();
		try {
			allCandidates = candidateService.getAllCandidates();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allCandidates;
	}

	// localhost:8088/admin/update/1
	@PutMapping("/update/{cId}")
	public Candidate updateCandidate(@PathVariable int cId, @RequestBody UpdateCandidateRequest request)
			throws NullException {
		Candidate existingCandidate = candidateService.getCandidateBycId(cId);
		existingCandidate.setcId(request.getcId()); // Update specific properties as needed

		return candidateService.addCandidate(existingCandidate);
	}

	// localhost:8088/admin/delete/1
	@DeleteMapping("/delete/{searchcId}")
	public void deleteCandidateById(@PathVariable int searchcId) {

		try {
			candidateService.deleteCandidateById(searchcId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// localhost:8088/admin/id/1
	@GetMapping("/cId/{searchcId}")
	public Candidate getCandidateByID(@PathVariable int searchcId) throws NullException {
		return candidateService.getCandidateBycId(searchcId);
	}

	// localhost:8088/admin/id?range1=6&range2=7
	@GetMapping("/cId")
	public List<Candidate> getCandidatesBetweenIds(@RequestParam int range1, @RequestParam int range2)
			throws NullException {

		return candidateService.getCandidatesBetweenIds(range1, range2);
	}

	// localhost:8088/admin/sort/gujarath
	@GetMapping("/sort/{constituency}")
	public List<Candidate> getBySorting() throws NullException {
		List<Candidate> allSorted = new ArrayList<>();
		try {
			allSorted = candidateService.sortingCandidatesBasedOnConstituency();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allSorted;
	}

	@GetMapping("/voterId/{voterId}")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnVoterId(@PathVariable int voterId) {
		logger.info("Fetching data for ID: {}", voterId);

		RequiredResponse requiredResponse = new RequiredResponse();

		Candidate candidate = candidateRepository.findBycId(voterId).get(voterId);
		requiredResponse.setCandidate(candidate);
		List<Voter> listofVoters = restTemplate.getForObject("http://Voter/voter/cId/" + voterId, List.class);
		requiredResponse.setVoter(listofVoters);

		logger.info("Fetched data for ID: {}", voterId);

		return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
	}

}
