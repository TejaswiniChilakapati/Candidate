package com.candidate.controller;

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

import com.candidate.entity.Candidate;
import com.candidate.service.CandidateService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200/")
public class AdminCandidateController {
	@Autowired
	CandidateService candidateService;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	private String searchPartyname;

	// localhost:8888/admin/addCandidate
	@PostMapping("/addCandidate")
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) throws Exception {

		Candidate savedCandidate = candidateService.addCandidate(candidate);
		return new ResponseEntity<Candidate>(savedCandidate, HttpStatus.CREATED);
	}

	@GetMapping("/allCandidates")
	public List<Candidate> getAllCandidates() {
		try {
			List<Candidate> allExtractedCandidates = candidateService.getAllCandidates();
			return allExtractedCandidates;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	// localhost:8088/admin/update/1
	@PutMapping("/update/{Id}")
	public Candidate updateCandidate(@PathVariable int Id, @RequestBody Candidate candidateDetails) throws Exception {
		candidateService.getCandidateById(Id);
		candidateDetails.setId(Id);
		Candidate updateCandidate = candidateService.addCandidate(candidateDetails);
		return updateCandidate;
	}

	// localhost:8088/admin/delete/1
	@DeleteMapping("/delete/{searchId}")
	public void deleteCandidateById(@PathVariable int searchId) {

		try {
			candidateService.deleteCandidateById(searchId);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// localhost:8088/admin/id/1
	@GetMapping("/id/{searchId}")
	public Candidate getCandidateByID(@PathVariable int searchId) throws Exception {
		return candidateService.getCandidateById(searchId);
	}

	// localhost:8088/admin/id?range1=6&range2=7
	@GetMapping("/id")
	public List<Candidate> getCandidatesBetweenIds(@RequestParam int range1, @RequestParam int range2)
			throws Exception {

		return candidateService.getCandidatesBetweenIds(range1, range2);
	}

	// localhost:8088/admin/sort/gujarath
	@GetMapping("/sort/{constituency}")
	public List<Candidate> getBySorting() throws Exception {
		List<Candidate> allSorted = candidateService.SortingCandidatesBasedOnConstituency();
		return allSorted;
	}

}
