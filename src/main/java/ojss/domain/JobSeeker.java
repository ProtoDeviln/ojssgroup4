package ojss.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "job_seeker")
@Entity
public class JobSeeker extends User {

    @Column(name = "fname")
    private String firstName;

    @Column(name = "lname")
    private String lastName;

    @Column
    private String exp;


    /*
    @OneToMany(mappedBy = "jobSeeker")
    private Set<Application> applications = new HashSet<>();*/

    @ManyToMany(mappedBy = "jobSeekers")
    private Set<Job> jobs = new HashSet<>();

    @ManyToMany(mappedBy = "jobSeekers")
    private Set<Skill> skills = new HashSet<>();

    @OneToMany(mappedBy = "jobSeeker")
    private Set<Invitation> invitations = new HashSet<>();

    public JobSeeker(Long id, String exp, String email, String suburb, int postcode, String state, String address, Long phoneNumber, String userName, String password, String fname, String lname, String exp1, HashSet<Skill> skills, HashSet<Job> jobs) {
        super(id, exp, email, suburb, postcode, state, address, phoneNumber, userName, password);
        this.firstName = fname;
        this.lastName = lname;
        this.exp = exp1;
        this.skills = skills;
        this.jobs = jobs;
    }

    public JobSeeker() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }

}

