package ojss.repository;


import ojss.domain.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import org.springframework.stereotype.Repository;

//@Repository("JobSeekerRepository")
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    JobSeeker findJobSeekerById(Long id);

    JobSeeker findJobSeekerByEmail(String email);

    List<JobSeeker> findJobSeekersBySkills(String skill_nm);

    //List<JobSeeker> findJobSeekersBySuburbIn()
}