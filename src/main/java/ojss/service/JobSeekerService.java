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

    public JobSeeker findJobSeekerByEmail(String email)
    {
        return jobSeekerRepository.findJobSeekerByEmail(email);
    }

    public JobSeeker findJobSeekerById(long id)
    {
        return jobSeekerRepository.findJobSeekerById(id);
    }

    public void updateJobSeeker(String address, String userName, int phone_number, String state, String suburb, String exp, long id)
    {
        jobSeekerRepository.updateJobSeekerById(address, userName, phone_number, state, suburb, exp, id);
    }

    public void addNewJobSeeker(JobSeeker jobSeeker) {
        jobSeekerRepository.save(jobSeeker);
    }
}
