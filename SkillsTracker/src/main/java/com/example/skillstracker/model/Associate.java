package com.example.skillstracker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "associate")
public class Associate {
    @Id
    @Column(name = "associate_id")
    private Integer associateId;
    @Column(name = "associate_name")
    private String associateName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @ManyToMany
    @Column(name="skills")
    private List<Skill> skills;

    public Associate() {super();}

    public Associate(Integer associateId, String associateName, String emailId, String mobileNumber, List<Skill> skills) {
        this.associateId = associateId;
        this.associateName = associateName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.skills = skills;
    }


    public Integer getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Integer associateId) {
        this.associateId = associateId;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public String getAssociateName() {return associateName;}

    public void setAssociateName(String associateName) {this.associateName = associateName;}


    public String getEmailId() {return emailId;}

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
