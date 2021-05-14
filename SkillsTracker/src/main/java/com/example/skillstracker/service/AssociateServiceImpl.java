package com.example.skillstracker.service;

import com.example.skillstracker.dao.AssociateDao;
import com.example.skillstracker.model.Associate;
import com.example.skillstracker.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssociateServiceImpl implements AssociateService {
    private AssociateDao associateDao;
    @Autowired
    public AssociateServiceImpl(AssociateDao associateDao) {
        super();
        this.associateDao = associateDao;
    }
    @Override
    public List<Associate> getAllAssociates() {
        // TODO Auto-generated method stub
        return associateDao.findAll();
    }

    @Override
    public Associate createAssociate(Associate associate) {
        // TODO Auto-generated method stub
        return associateDao.save(associate);
    }

    @Override
    public Associate findById(int theId) {
        Associate theAssociate=null;
        Optional<Associate> result=associateDao.findById(theId);
        if(result.isPresent())
        {
            theAssociate=result.get();
        }
        else {
            throw new RuntimeException("Did not find associate id - " + theId);
        }

        return theAssociate;
    }

    @Override
    public List<Associate> findByName(String associateName) {
        return associateDao.findByName(associateName);
    }

    @Override
    public List<Associate> findByEmailId(String associateEmailId) {
        return associateDao.findByEmailId(associateEmailId);
    }

    @Override
    public List<Associate> findByMobileNumber(String associateMobileNumber) {
        return associateDao.findByMobileNumber(associateMobileNumber);
    }


    @Override
    public Associate deleteAssociateById(int theId) {
        Optional<Associate> associate=associateDao.findById(theId);
        if(associate.isPresent())
        {
            associateDao.deleteById(theId);
        }
        else {
            throw new RuntimeException("Did not find associate id - " + theId);
        }

        return null;
    }


    @Override
    public Associate findBySkills(String skillName) {
        return associateDao.findBySkills(skillName);
    }
}
