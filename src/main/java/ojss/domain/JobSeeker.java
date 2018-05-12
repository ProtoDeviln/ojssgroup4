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

    @ManyToMany(mappedBy = "jobSeekers")
    private HashSet<Job> jobs;

    @ManyToMany(mappedBy = "jobSeekers")
    private HashSet<Skill> skills;

    public JobSeeker(Long id, String exp, String email, String suburb, int postcode, String state, String address, Long phoneNumber, String userName, String password, String fname, String lname, String exp1, HashSet<Skill> skills, HashSet<Job> jobs) {
        super(id, exp, email, suburb, postcode, state, address, phoneNumber, userName, password);
        this.firstName = fname;
        this.lastName = lname;
        this.exp = exp1;
        this.skills = skills;
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

    public void setSkills(HashSet<Skill> skills) {
        this.skills = skills;
    }

    public HashSet<Job> getJobs() {
        return jobs;
    }

    public void setJobs(HashSet<Job> jobs) {
        this.jobs = jobs;
    }

}

