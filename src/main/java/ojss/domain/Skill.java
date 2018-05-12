package ojss.domain;


import javax.persistence.*;
import java.util.HashSet;

@Table(name = "skill")
public class Skill {


    @Column(name = "skill_id", updatable = false, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "skill_nm")
    private String skillName;

    @Column(name = "skill_desc")
    private String skillDescription;

    @ManyToMany
    @JoinTable(name = "job_seeker_has_skill",
             joinColumns = { @JoinColumn(name = "job_seeker_id") },
             inverseJoinColumns = { @JoinColumn(name = "skill_skill_id") })
    private HashSet<JobSeeker> jobSeekers;

    public Skill(Long id, String skillName, String skillDescription, HashSet<JobSeeker> jobSeekers) {
        this.skillName = skillName;
        this.id = id;
        this.skillDescription = skillDescription;
        this.jobSeekers = jobSeekers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public HashSet<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(HashSet<JobSeeker> jobSeekers) {
        this.jobSeekers = jobSeekers;
    }
}
