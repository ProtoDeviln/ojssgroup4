package ojss.domain;

import javax.persistence.*;

@Entity
@Table(name = "application")
@IdClass(value=ApplicationRecord.class)
public class Application {


    @Id
    @Column(name = "job_seeker_id")
    private Long jobSeekerId;

    @Id
    @Column(name = "job_job_id")
    private Long jobId;

    @Id
    @Column(name = "time")
    private String time;

    @Id
    @Column(name = "job_job_recruiter_id")
    private Long jobRecruiterId;

    @Column(name = "app_detail")
    private String applicationDescription;

    @ManyToOne
    @JoinColumn(name = "job_job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    public Application() {
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getJobRecruiterId() {
        return jobRecruiterId;
    }

    public void setJobRecruiterId(Long jobRecruiterId) {
        this.jobRecruiterId = jobRecruiterId;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}