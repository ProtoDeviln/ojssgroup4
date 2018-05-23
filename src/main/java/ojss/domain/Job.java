package ojss.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "job")

public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long jobId;

    @Column(name = "job_name")
    private String jobName;

    @ManyToMany
    @JoinTable(name = "application",
            joinColumns = {@JoinColumn(name = "job_job_id")},//, @JoinColumn(name = "job_job_recruiter_id")
            inverseJoinColumns = {@JoinColumn(name = "job_seeker_id")})
    private Set<JobSeeker> jobSeekers = new HashSet<>();

    @ManyToOne(optional=false)
    @JoinColumn(name = "job_recruiter_id")
    private JobRecruiter jobRecruiter;

    @Column
    private String suburb;

    @Column
    private int postcode;

    @Column
    private String state;

    @Column
    private Double salary;

    @Column(name = "job_category")
    private String jobCategory;

    @Column(name = "job_desc")
    private String jobDescription;

    @Column(name = "job_type")
    private String jobType;

    public Job(String jobName, Set<JobSeeker> jobSeekers, JobRecruiter jobRecruiter, String suburb, int postcode, String state, Double salary, String jobCategory, String jobDescription, String jobType) {
        this.jobName = jobName;
        this.jobSeekers = jobSeekers;
        this.jobRecruiter = jobRecruiter;
        this.suburb = suburb;
        this.postcode = postcode;
        this.state = state;
        this.salary = salary;
        this.jobCategory = jobCategory;
        this.jobDescription = jobDescription;
        this.jobType = jobType;
    }
    public Job(){}

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Set<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(Set<JobSeeker> jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public JobRecruiter getJobRecruiter() {
        return jobRecruiter;
    }

    public void setJobRecruiter(JobRecruiter jobRecruiter) {
        this.jobRecruiter = jobRecruiter;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}