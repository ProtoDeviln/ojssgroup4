package ojss.service;


import ojss.domain.JobRecruiter;
import ojss.repository.JobRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobRecruiterService {

    @Autowired
    private JobRecruiterRepository jobRecruiterRepository;

    public JobRecruiter findByEmail(String email) {
        return jobRecruiterRepository.findByEmail(email);
    }

    public void addJobRecruiter(JobRecruiter jobRecruiter) {
        jobRecruiterRepository.save(jobRecruiter);
    }

    public JobRecruiter verifyJobRecruiter(JobRecruiter jobRecruiter) {
        if (jobRecruiterRepository.findByEmailAndPassword(jobRecruiter.getEmail(), jobRecruiter.getPassword()) == null) {
            jobRecruiter = null;
            return jobRecruiter;
        } else {
            return jobRecruiter;
        }
    }







}
