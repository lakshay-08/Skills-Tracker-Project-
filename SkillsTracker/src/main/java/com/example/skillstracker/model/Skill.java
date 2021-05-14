package com.example.skillstracker.model;

import javax.persistence.*;

@Entity
@Table(name="skills")
public class Skill {
    @Id
    @Column(name = "skill_id")
    private Integer skillId;
    @Column(name = "skill_name")
    private String skillName;


    public Skill() {super();}

    public Skill(Integer skillId, String skillName) {
        this.skillId = skillId;
        this.skillName = skillName;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
