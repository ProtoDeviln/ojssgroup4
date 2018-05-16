package ojss.service;


import ojss.domain.JobRecruiter;
import ojss.repository.JobRecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public boolean verifyJobRecruiter(JobRecruiter jobRecruiter) {
        if (jobRecruiterRepository.findByEmailAndPassword(jobRecruiter.getEmail(), jobRecruiter.getPassword()).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }









}
