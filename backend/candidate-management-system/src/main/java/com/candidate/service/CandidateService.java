package com.candidate.service;

import java.util.*;
import java.io.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.candidate.dto.CsvImport;
import com.candidate.model.Candidate;
import com.candidate.repository.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
    private CandidateRepository repo;

    public List<Candidate> getAllCandidates() {
        return repo.findAll();
    }

    public Candidate createCandidate(Candidate candidate) {
        return repo.save(candidate);
    }

    public Candidate updateCandidate(Long id, Candidate candidate) {

        Candidate existing = repo.findById(id).orElseThrow();

        existing.setName(candidate.getName());
        existing.setStatus(candidate.getStatus());
        existing.setExperience(candidate.getExperience());
        existing.setNoticePeriod(candidate.getNoticePeriod());
        existing.setPrimarySkills(candidate.getPrimarySkills());
        existing.setSecondarySkills(candidate.getSecondarySkills());
        existing.setCell(candidate.getCell());
        existing.setEmail(candidate.getEmail());
        existing.setLocation(candidate.getLocation());
        existing.setPreviousCompany(candidate.getPreviousCompany());
        existing.setCtc(candidate.getCtc());
        existing.setEctc(candidate.getEctc());
        existing.setMode(candidate.getMode());
        existing.setEducation(candidate.getEducation());
        existing.setComment(candidate.getComment());
        existing.setClientRound(candidate.getClientRound());

        return repo.save(existing);
    }

    public void deleteCandidate(Long id) {
        repo.deleteById(id);
    }
    
    public  CsvImport importCSV(MultipartFile file) {
    	
    	String filename = file.getOriginalFilename();
    	
    	if(filename == null || !filename.toLowerCase().endsWith(".csv")) {
    		throw new IllegalArgumentException("Only CSV files are allowed");
    	}
    	
    	String contentType = file.getContentType();
    	if(contentType == null ||
    	    (!contentType.equals("text/csv")&&
    	    		!contentType.equals("application/vnd.ms-excel"))) {
    		throw new IllegalArgumentException("Invalid file type");
    	}
    	 int successCount =0;
    	 int failedCount =0;
    	 
    	 List<String> errors = new ArrayList<>();
    	 List<Candidate> validCandidates = new ArrayList<>();
    	 
    	 try(BufferedReader br = new BufferedReader(
    			 new InputStreamReader(file.getInputStream()))){
    		 
    		 String line;
    		 
    		 boolean firstLine = true;
    		 
    		 while((line = br.readLine()) != null) {
    			 
    			 if(firstLine) {
    				 firstLine = false;
    				 continue;
    			 }
    			 
    			 try {
    				 String[] data =line.split(", ");
    				 
    				 if(data.length < 16) {
    					 failedCount++;
    					 errors.add("Invalid column count: " + line);
    					 continue;
    				 }
    				 
    				 Candidate c = new Candidate();

                     c.setStatus(data[0]);
                     c.setName(data[1]);
                     c.setExperience(Float.parseFloat(data[2]));
                     c.setNoticePeriod(data[3]);
                     c.setPrimarySkills(data[4]);
                     c.setSecondarySkills(data[5]);
                     c.setCell(Long.parseLong(data[6]));
                     c.setEmail(data[7]);
                     c.setLocation(data[8]);
                     c.setPreviousCompany(data[9]);
                     c.setCtc(Double.parseDouble(data[10]));
                     c.setEctc(Double.parseDouble(data[11]));
                     c.setMode(data[12]);
                     c.setEducation(data[13]);
                     c.setComment(data[14]);
                     c.setClientRound(data[15]);

                     validCandidates.add(c);

                     successCount++;

                 } catch (Exception e) {

                     failedCount++;
                     errors.add("Failed row: " + line);
                 }
    			 }
    		     
    		 repo.saveAll(validCandidates);
    		 }catch(Exception e) {
    			 errors.add("File processing error: " + e.getMessage());		 
    	 }
    	 
    	 return new CsvImport(
    			 successCount,
    			 failedCount,
    			 errors
    			 );
    }
}
