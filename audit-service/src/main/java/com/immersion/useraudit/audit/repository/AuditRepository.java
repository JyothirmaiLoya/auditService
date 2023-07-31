package com.immersion.useraudit.audit.repository;

import com.immersion.useraudit.audit.domain.entities.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AuditRepository extends JpaRepository<AuditEntity, String> {

    /*public AuditEntity findByUser_id(String userId);*/
    public AuditEntity findByUserid(String userId);

    void deleteByUserId(String userId);
    public void deleteByProcessedTimeBefore(LocalDateTime dateBefore);

    //void delete(Integer days);

   // public void deleteByUserId(String userId);
    //public void deleteByProcessedTimeBefore(LocalDateTime dateBefore);

   /* @Modifying
    @Query
            ("DELETE FROM audit_entity WHERE cur_timestamp < :localDateTime ")
    void deleteOldAuditDetails(@Param("locatDateTime") LocalDateTime localDateTime);*/
}
