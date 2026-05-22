package com.candidate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.candidate.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
