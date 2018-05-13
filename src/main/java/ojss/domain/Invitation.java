package ojss.domain;

import javax.persistence.*;


@Entity
@Table(name = "invitation")
public class Invitation {


    @Id
    @Column(name = "invit_id")
    private Long invitationId;

    @Column(name = "invit_detail")
    private String invitationDescription;

    @ManyToOne
    @JoinColumn(name = "job_recruiter_id")
    private JobRecruiter jobRecruiter;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;

    public Invitation(Long invitationId, String invitationDescription, JobRecruiter jobRecruiter, JobSeeker jobSeeker) {
        this.invitationId = invitationId;
        this.invitationDescription = invitationDescription;
        this.jobRecruiter = jobRecruiter;
        this.jobSeeker = jobSeeker;


    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }

    public String getInvitationDescription() {
        return invitationDescription;
    }

    public void setInvitationDescription(String invitationDescription) {
        this.invitationDescription = invitationDescription;
    }

    public JobRecruiter getJobRecruiter() {
        return jobRecruiter;
    }

    public void setJobRecruiter(JobRecruiter jobRecruiter) {
        this.jobRecruiter = jobRecruiter;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
}
