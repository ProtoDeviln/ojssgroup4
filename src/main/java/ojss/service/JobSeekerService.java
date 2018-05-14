package ojss.service;

import ojss.domain.JobSeeker;
import ojss.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    private JobSeekerRepository jobSeekerRepository;

    @Autowired
    public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public JobSeeker findJobSeekerByEmail(String email) {
        return jobSeekerRepository.findJobSeekerByEmail(email);
    }

    public void addNewJobSeeker(JobSeeker jobSeeker) {
        jobSeekerRepository.save(jobSeeker);
    }
}
