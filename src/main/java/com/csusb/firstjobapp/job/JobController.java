package com.csusb.firstjobapp.job;

import com.csusb.firstjobapp.job.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    private JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobService.createJob(job);
        return  "job added Successfully";
    }
    @GetMapping("/jobs/{id}")
    public Job findById(@PathVariable Long id){
        Job job= jobService.findById(id);
        if(job!=null) {
            return job;
        }
        return new Job(
                3L,"testEngineer","testtheapplicarion","60000","70000","california"
        );
    }

}
