package com.example.skillstracker.model;

import javax.persistence.*;

@Entity
public class Associate {
    @Id
    private Integer associateId;
    @Column(name = "associate_name")
    private String associateName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "mobile_number")
    private String mobileNumber;
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="associateId")
    private Skill skill;
    public Associate() {
        super();
    }

    public Associate(Integer associateId, String associateName, String emailId, String mobileNumber) {
        this.associateId = associateId;
        this.associateName = associateName;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
    }

    public Integer getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Integer associateId) {
        this.associateId = associateId;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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
