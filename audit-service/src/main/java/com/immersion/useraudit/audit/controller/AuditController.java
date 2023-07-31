package com.immersion.useraudit.audit.controller;

import com.immersion.useraudit.audit.domain.entities.AuditEntity;
import com.immersion.useraudit.audit.service.serviceImpl.AuditServiceImpl;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

@Slf4j
@RestController
//@RequestMapping("/audit")
public class AuditController {
    @Autowired
    private AuditServiceImpl auditServiceImpl;


   // private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @PostMapping("/auditDetails")
    public AuditEntity saveAudit(@RequestBody AuditEntity auditEntity) {
        log.info("PostMapping: save details");
        System.out.println(" ");

       /* if(auditEntity.getProcessedTime() instanceof String) {
            //auditEntity.setProcessedTime(LocalDateTime.parse(auditEntity.getProcessedTime()));
            Object entity = (Object) auditEntity;

        }*/
       // log.info(String.format("---> [%s]",auditEntity.getProcessedTime()));
        return auditServiceImpl.saveAudit(auditEntity);

    }
        @GetMapping("/getAuditById/{userId}")

        public Optional<AuditEntity> getAuditById(@PathVariable String userId) {
            log.info("PostMapping: details saved");
            return auditServiceImpl.getAuditById(userId);

        }
       /* public AuditEntity getAuditById (@PathVariable String userId){
            return auditServiceImpl.getAuditById(userId);
        }*/

        @DeleteMapping("/deleteAuditById/{userId}")
        public void deleteAuditById (@PathVariable String userId){
           log.info("record deleted by id");
            auditServiceImpl.deleteAuditByUserId(userId);
        }


    /*@Transactional
    public void deleteAuditById(String userId){
        log.info(String.format("Received request for AuditService.deleteAuditDetails [%s]",userId));
        auditServiceImpl.deleteAuditById(userId);
        log.info(String.format("Completed request for AuditService.deleteAuditDetails [%s]",userId));
    }*/

    @DeleteMapping("/deleteOldDetails/{days}")
    public void  deleteByProcessedTimeBefore(@PathVariable Integer days){
        log.info("old records deleted");
            auditServiceImpl.deleteByProcessedTimeBefore(days);
        }




    }


