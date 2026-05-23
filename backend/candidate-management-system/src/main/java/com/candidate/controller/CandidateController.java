package com.candidate.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;

import com.candidate.dto.CsvImport;
import com.candidate.model.Candidate;
import com.candidate.repository.CandidateRepository;
import com.candidate.service.CandidateService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CandidateController {

	@Autowired
	private CandidateService service;
	
	@GetMapping("/candidates")
	public List<Candidate> getAllCandidates(){
		return service.getAllCandidates();
	}
	
	@PostMapping("/candidates")
	public Candidate createCandidate(@RequestBody Candidate candidate) {
		return service.createCandidate(candidate);
	}
	
	@PutMapping("/candidates/{id}")
	public Candidate update(@PathVariable Long id, @RequestBody Candidate candidate) {
		return service.updateCandidate(id, candidate);
	}
	
	@DeleteMapping("/candidates/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteCandidate(id);
		return "Deleted Successfully";
	}
	
	@PostMapping("/candidates/import")
	public CsvImport importCSV(@RequestParam("file") MultipartFile file) {
		
		 return service.importCSV(file);
	}
	

}
