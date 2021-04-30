package com.example.skillstracker.model;

import javax.persistence.*;

@Entity
@Table(name="skill")
public class Skill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer skillId;
    @Column(name = "associate_id")
    private Integer associateID;
    @Column(name = "skill_name")
    private String skillName;
    @OneToOne(mappedBy="Skill",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private Associate associate;

    public Skill() {super();}

    public Skill(Integer skillId, Integer associateID, String skillName) {
        this.skillId = skillId;
        this.associateID = associateID;
        this.skillName = skillName;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getAssociateID() {
        return associateID;
    }

    public void setAssociateID(Integer associateID) {
        this.associateID = associateID;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
