package com.candidate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.model.Candidate;
import com.candidate.repository.CandidateRepository;

@RestController
@RequestMapping("/api/v1/")
public class CandidateController {

	@Autowired
	private CandidateRepository candidateRepo;
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates(){
		return candidateRepo.findAll();
	}
	
}
