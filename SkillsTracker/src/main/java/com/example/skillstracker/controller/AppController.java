package com.example.skillstracker.controller;

import com.example.skillstracker.dao.AssociateDao;
import com.example.skillstracker.dao.SkillDao;
import com.example.skillstracker.model.Associate;
import com.example.skillstracker.model.Skill;
import com.example.skillstracker.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class AppController {
    private AssociateService associateService;
    private SkillDao skillDao;
    private AssociateDao associateDao;
    @Autowired
    public AppController(AssociateService associateService, SkillDao skillDao, AssociateDao associateDao) {
        super();
        this.associateService = associateService;
        this.skillDao = skillDao;
        this.associateDao = associateDao;
    }

    @GetMapping("/associates")
    public List<Associate> getAssociates()
    {
        return associateService.getAllAssociates();
    }

    @GetMapping("/associates/skills")
    public List<Skill> getSkills()
    {
        return skillDao.findAll();
    }

    @PostMapping("/associates")
    public Associate createAssociate(@RequestBody Associate associate) {
        return associateDao.save(associate);
    }

    @PostMapping("/associates/skill")
    public Skill createSkill(@RequestBody Skill skill) {
        return skillDao.save(skill);
    }

    @GetMapping("/associates/{associateId}")
    public ResponseEntity<Associate> getById(@PathVariable("associateId") Integer associateId) {
        Associate associate = associateService.findById(associateId);
        return ResponseEntity.ok().body(associate);
    }

     @DeleteMapping("/associates/{associateId}")
    public Map<String, Boolean> deleteAssociate(@PathVariable("associateId") int associateId){
        Associate associate = associateService.findById(associateId);
        associateDao.delete(associate);
         Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return response;
    }

    @PutMapping("/associates/{id}")
    public ResponseEntity<Associate> Update(@PathVariable(value = "id") Integer id, @RequestBody Associate associate) {
        Associate tempAssociate = associateService.findById(id);
        tempAssociate.setAssociateName(associate.getAssociateName());
        tempAssociate.setEmailId(associate.getEmailId());
        tempAssociate.setMobileNumber(associate.getMobileNumber());
        tempAssociate.setSkills(associate.getSkills());
        final Associate updatedAssociate = associateDao.save(tempAssociate);
        return ResponseEntity.ok(updatedAssociate);
    }
}
