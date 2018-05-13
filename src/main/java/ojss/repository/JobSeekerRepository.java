package ojss.repository;


import ojss.domain.JobSeeker;
import org.springframework.data.repository.CrudRepository;


public interface JobSeekerRepository extends CrudRepository<JobSeeker, Long> {

}