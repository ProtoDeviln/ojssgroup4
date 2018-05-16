package ojss.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "job_recruiter")
public class JobRecruiter extends User{

    @Column(name = "busi_name" )
    private String bussinessName;

    @Column(name = "intro")
    private String introduction;

    @OneToMany(mappedBy = "jobRecruiter")
    private Set<Job> jobs = new HashSet<>();

    @OneToMany(mappedBy = "jobRecruiter")
    private Set<Invitation> invitations = new HashSet<>();

    @Column
    private String type;

    public JobRecruiter() {}

    public JobRecruiter(Long id, String exp, String email, String suburb, int postcode, String state, String address, Long phoneNumber, String userName, String password, String bussinessName, String introduction, Set<Job> jobs, Set<Invitation> invitations, String type) {
        super(id, exp, email, suburb, postcode, state, address, phoneNumber, userName, password);
        this.bussinessName = bussinessName;
        this.introduction = introduction;
        this.jobs = jobs;
        this.invitations = invitations;
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

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

    public Set<Invitation> getInvitations() {
        return invitations;
    }

    public void setInvitations(Set<Invitation> invitations) {
        this.invitations = invitations;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


