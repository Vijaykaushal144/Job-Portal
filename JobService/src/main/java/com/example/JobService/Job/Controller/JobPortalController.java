package com.example.JobService.Job.Controller;


import com.example.JobService.Job.Dto.JobDto;
import com.example.JobService.Job.Entity.Job;
import com.example.JobService.Job.Service.JobPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobPortalController {


    @Autowired
    JobPortalService jobService;


    //dependency injection using the constructor.
    JobPortalController(JobPortalService portalService) {
        this.jobService = portalService;
    }

    @GetMapping("/getAllJob")
    public List<JobDto> getAllJob() {
        return jobService.getAllJob();
    }


    @PostMapping("/addJob")
    public ResponseEntity<String> addJob(@RequestBody Job job) {
        jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.OK).body("Job Created Successfully");

    }


    @GetMapping("/getJobByID/{jid}")
    public ResponseEntity<JobDto> getjobByID(@PathVariable int jid) {

        JobDto jobDto = jobService.getjobById(jid);
        if (jobDto != null) {
            return new ResponseEntity<>(jobDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteJob/{jid}")
    public ResponseEntity<String> deletejob(@PathVariable int jid) {
        boolean value = jobService.deleteById(jid);
        if (value) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No Job Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{jid}")
    public ResponseEntity<String> updateJob(@PathVariable int jid, @RequestBody Job job) {
        boolean value = jobService.updateByID(jid, job);
        if (value) {
            return new ResponseEntity<>("Job Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not Found ! ", HttpStatus.NOT_FOUND);
    }
}
