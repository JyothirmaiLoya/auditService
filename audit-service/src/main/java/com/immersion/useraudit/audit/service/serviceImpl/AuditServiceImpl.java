package com.immersion.useraudit.audit.service.serviceImpl;

import com.immersion.useraudit.audit.domain.entities.AuditEntity;
import com.immersion.useraudit.audit.repository.AuditRepository;
import com.immersion.useraudit.audit.service.AuditService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class AuditServiceImpl implements AuditService {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    public AuditRepository auditRepository;


    @Override
    public AuditEntity saveAudit(AuditEntity auditEntity) {

        return auditRepository.save(auditEntity);
    }

    @Override
    public Optional<AuditEntity> getAuditById(String userId) {
        return Optional.ofNullable(auditRepository.findByUserid(userId));
    }


  /*  @Override
    public void deleteByProcessedTimeBefore(Integer days) {

    }
*/

   /* @Override
    public void deleteByProcessedTimeBefore(Integer days) {
        LocalDateTime currentDate = LocalDateTime.now();
        auditRepository.deleteByProcessedTimeBefore(currentDate.minusDays(days));
    }*/

    @Transactional
    public void deleteAuditByUserId(String userId) {
        logger.info(String.format("Received request for AuditService.deleteAuditDetails [%s]", userId));
        auditRepository.deleteByUserId(userId);

    }

        //@Override
    @Transactional
    public void deleteByProcessedTimeBefore( Integer days){
        logger.info(String.format("Received request for AuditService.deleteOldRecords [%d]",days));
        LocalDateTime currentDate = LocalDateTime.now();
        auditRepository.deleteByProcessedTimeBefore(currentDate.minusDays(days));
        logger.info(String.format("Completed request for AuditService.deleteOldRecords [%d]",days));
    }
}
