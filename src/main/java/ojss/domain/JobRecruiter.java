package ojss.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;

@Entity(name = "job_recruiter")
public class JobRecruiter extends User{

    @Column(name = "busi_name" )
    private String bussinessName;

    @Column(name = "intro")
    private String introduction;

    @OneToMany(mappedBy = "jobRecruiter")
    private HashSet<Job> jobs;

    @OneToMany(mappedBy = "jobRecruiter")
    private HashSet<Invitation> invitations;

    @Column
    private String type;

    public JobRecruiter(Long id, String exp, String email, String suburb, int postcode, String state, String address, Long phoneNumber, String userName, String password, String bussinessName, String introduction, String type) {
        super(id, exp, email, suburb, postcode, state, address, phoneNumber, userName, password);
        this.bussinessName = bussinessName;
        this.introduction = introduction;
        this.type = type;
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashSet<Job> getJobs() {
        return jobs;
    }

    public void setJobs(HashSet<Job> jobs) {
        this.jobs = jobs;
    }
}


