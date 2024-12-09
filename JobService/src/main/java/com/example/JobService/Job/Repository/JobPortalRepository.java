package com.example.JobService.Job.Repository;

import com.example.JobService.Job.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPortalRepository extends JpaRepository<Job,Integer> {
}
