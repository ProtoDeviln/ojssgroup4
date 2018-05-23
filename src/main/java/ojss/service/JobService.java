package ojss.service;


import ojss.domain.Job;
import ojss.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //public List<Job> findAll();

    //List<Job> findAll(int pageNum, int pageSize, Job job);

    public List<Job> findByJobName (String jobName){
        return jobRepository.findAllByJobName(jobName);
    }


}
