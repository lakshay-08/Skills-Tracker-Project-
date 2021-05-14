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
    public List<Associate> findByKeyword(String keyword) {
        return associateDao.findByKeyword(keyword);
    }

    @Override
    public List<Skill> findBySkill_title(String keyword) {
        return null;
    }

    @Override
    public Associate findBySkills(String skill_title) {
        return associateDao.findBySkills(skill_title);
    }
}
