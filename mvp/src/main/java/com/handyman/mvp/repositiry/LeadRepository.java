package com.handyman.mvp.repositiry;

import com.handyman.mvp.model.Lead;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query(value = "select * from Leads l where l.id = ?1")
    Lead getLeadById(long id);

}
