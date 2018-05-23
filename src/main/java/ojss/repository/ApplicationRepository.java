package ojss.repository;

import ojss.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {


    List<Application> findApplicationByJobId(Long JobId);

    List<Application> findApplicationByJobRecruiterId(Long JobId);

}
