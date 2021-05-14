package com.example.skillstracker.service;

import com.example.skillstracker.model.Associate;
import com.example.skillstracker.model.Skill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AssociateService {
    public List<Associate> getAllAssociates();
    public Associate createAssociate(Associate associate);
    public Associate findById(int theId);
    List<Associate> findByName(String associateName);
    List<Associate> findByEmailId(String associateEmailId);
    List<Associate> findByMobileNumber(String associateMobileNumber);
    public Associate deleteAssociateById(int theId);
    public Associate findBySkills(String skillName);
}
