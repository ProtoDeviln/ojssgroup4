package ojss.repository;

import ojss.domain.JobRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRecruiterRepository extends JpaRepository<JobRecruiter, Long> {
    JobRecruiter findByEmail(String email);
}
