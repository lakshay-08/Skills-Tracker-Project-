package com.example.skillstracker.dao;

import com.example.skillstracker.model.Associate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Resource;
import java.util.List;

@Resource
public interface AssociateDao extends JpaRepository<Associate, Integer> {
    @Query(value="select * from associate_detail e where e.name like %:keyword% or e.email like %:keyword% or e.mobile_number like %:keyword%", nativeQuery = true)
    List<Associate> findByKeyword(@Param("keyword") String keyword);
    @Query
    public Associate findBySkills(String skill_title);
}
