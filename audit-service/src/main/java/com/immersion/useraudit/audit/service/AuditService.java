package com.immersion.useraudit.audit.service;

import com.immersion.useraudit.audit.domain.entities.AuditEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AuditService {

   /*AuditEntity saveAudit(AuditEntity auditEntity);*/
    AuditEntity saveAudit( AuditEntity auditEntity);

    Optional<AuditEntity> getAuditById(String userId);
    void deleteAuditByUserId(String userId);
    void deleteByProcessedTimeBefore(Integer days);

/*
AuditEntity getAuditDetailsByUserId(Integer id);

void deleteAuditDetailsByUserId(Integer id);

 AuditEntity deleteOldAuditDetails(AuditEntity auditEntity);
*/


}
