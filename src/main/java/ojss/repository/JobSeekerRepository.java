package ojss.repository;


import ojss.domain.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import org.springframework.stereotype.Repository;

//@Repository("JobSeekerRepository")
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    JobSeeker findJobSeekerById(Long id);

    JobSeeker findJobSeekerByEmail(String email);

    List<JobSeeker> findJobSeekersBySkills(String skill_nm);
    @Modifying
    @Query("update JobSeeker s set s.address = ?1, s.nickName = ?2, s.phoneNumber= ?3, s.state = ?4, s.suburb = ?5 , s.exp = ?6  where s.id = ?7")
    void updateJobSeekerById (String address, String userName, int phone_number, String state, String suburb, String exp, long id);
    JobSeeker findByEmailAndPassword(String email, String password);
}