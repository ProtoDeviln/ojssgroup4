package ojss.service;


import ojss.domain.Job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    List<Job> findAll(int pageNum, int pageSize, Job job);


}
