package ojss.domain;

import java.io.Serializable;

public class ApplicationRecord implements Serializable {
    private Long jobId;
    private Long jobSeekerId;
    private String time;
    private Long jobRecruiterId;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String tiem) {
        this.time = tiem;
    }

    public Long getJobRecruiterId() {
        return jobRecruiterId;
    }

    public void setJobRecruiterId(Long jobRecruiterId) {
        this.jobRecruiterId = jobRecruiterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicationRecord)) return false;

        ApplicationRecord that = (ApplicationRecord) o;

        if (getJobSeekerId() != that.getJobSeekerId()) return false;
        if (getJobId() != that.getJobId()) return false;
        if (getJobRecruiterId() != that.getJobRecruiterId()) return false;
        return getTime().equals(that.getTime());

    }

    @Override
    public int hashCode() {
        int result = getJobSeekerId().intValue();
        result = 3 * result + getJobId().intValue();
        result = 3 * result + getTime().hashCode();
        result = 3 * result + getJobRecruiterId().intValue();
        return result;
    }
}