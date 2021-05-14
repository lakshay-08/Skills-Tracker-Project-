package com.example.skillstracker.dao;

import com.example.skillstracker.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface AssociateDao extends JpaRepository<Associate, Integer> {
    @Query(value="SELECT * FROM associate WHERE associate_name=:associateName", nativeQuery = true)
    List<Associate> findByName(@Param("associateName") String associateName);
    @Query(value="SELECT * FROM associate WHERE email_id=:associateEmailId", nativeQuery = true)
    List<Associate> findByEmailId(@Param("associateEmailId") String associateEmailId);
    @Query(value="SELECT * FROM associate WHERE mobile_number=:associateMobileNumber", nativeQuery = true)
    List<Associate> findByMobileNumber(@Param("associateMobileNumber") String associateMobileNumber);
    @Query
    public Associate findBySkills(String skill_title);
}
