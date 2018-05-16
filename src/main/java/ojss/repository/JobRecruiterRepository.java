package ojss.repository;

import ojss.domain.JobRecruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRecruiterRepository extends JpaRepository<JobRecruiter, Long> {
    JobRecruiter findByEmail(String email);

    List<JobRecruiter> findByEmailAndPassword(String email, String password);
}
