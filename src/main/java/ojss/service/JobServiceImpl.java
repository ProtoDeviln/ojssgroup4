package ojss.service;


import ojss.domain.Job;
import ojss.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> findAll(int pageNum, int pageSize, Job job) {
        Pageable pageable = new PageRequest(pageNum, pageSize);
        List<Job> jList = jobRepository.findAll(new Specification<Job>() {
            @Override
            public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (job.getJobName() != null && !job.getJobName().equals("")) {
                    predicates.add(cb.like(root.get("jobName").as(String.class), "%" + job.getJobName() + "%"));
                }
                if (job.getJobCategory() != null && !job.getJobCategory().equals("")) {
                    predicates.add(cb.like(root.get("jobCategory").as(String.class), "%" + job.getJobCategory() + "%"));
                }
                if (job.getState() != null && !job.getState().equals("")) {
                    predicates.add(cb.like(root.get("state").as(String.class), "%" + job.getState() + "%"));
                }
                if (job.getSuburb() != null && !job.getSuburb().equals("")) {
                    predicates.add(cb.like(root.get("suburb").as(String.class), "%" + job.getSuburb() + "%"));
                }
                Predicate[] pre = new Predicate[predicates.size()];
                criteriaQuery.where(predicates.toArray(pre));
                return cb.and(predicates.toArray(pre));
            }

        }, pageable);

        return jList;
    }


}

