package com.example.skillstracker;

import com.example.skillstracker.dao.AssociateDao;
import com.example.skillstracker.dao.SkillDao;
import com.example.skillstracker.model.Associate;
import com.example.skillstracker.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import java.util.Arrays;

@SpringBootApplication
//@EnableEurekaClient

public class SkillsTrackerApplication implements CommandLineRunner {
    private AssociateDao associateDao;
    private SkillDao skillDao;

    @Autowired
    public SkillsTrackerApplication(AssociateDao associateDao, SkillDao skillDao) {
        super();
        this.associateDao = associateDao;
        this.skillDao = skillDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SkillsTrackerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Skill skill1 = new Skill(1, "Frontend Development");
        Skill skill2 = new Skill(2, "Testing");
        Skill skill3 = new Skill(3, "Backend Development");
        Skill skill4 = new Skill(4, "Android Development");
        Skill skill5 =new Skill(5,"Full Stack Development");
        Skill skill6 =new Skill(6,"Database Admin");
        Skill skill7 =new Skill(7,"Data Analyst");


        skillDao.save(skill1);
        skillDao.save(skill2);
        skillDao.save(skill3);
        skillDao.save(skill4);
        skillDao.save(skill5);
        skillDao.save(skill6);
        skillDao.save(skill7);

        associateDao.save(new Associate(1, "Bruce", "BruceWayne@email.com", "555-5555-0008", Arrays.asList(new Skill[]{skill1, skill2})));
        associateDao.save(new Associate(2, "Jhonny", "johnnyDepp@musk.com", "123-567-8900", Arrays.asList(new Skill[]{skill2, skill3})));
        associateDao.save(new Associate(3, "Peter", "PeterParker@spiderman.com", "975-3186-4202", Arrays.asList(new Skill[]{skill4})));
        associateDao.save(new Associate(4, "Andres", "andres@don.com", "942-5159-5401", Arrays.asList(new Skill[]{skill5})));
        associateDao.save(new Associate(5, "Xavi", "Xavi@Hernandase.com", "898-9889-8982", Arrays.asList(new Skill[]{skill7})));
        associateDao.save(new Associate(6, "Dwayne", "RockJhonson@wwe.com", "232-3232-3233", Arrays.asList(new Skill[]{skill6})));

        }

}
