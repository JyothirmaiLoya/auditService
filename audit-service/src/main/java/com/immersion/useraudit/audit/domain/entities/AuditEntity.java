package com.immersion.useraudit.audit.domain.entities;

import com.immersion.useraudit.audit.domain.enums.EventCode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;
/*import org.springframework.data.annotation.Id;*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
//(name = "audit1")
public class AuditEntity {
     @Id
     @GeneratedValue(strategy =  GenerationType.AUTO)

     private Integer id;
    private String correlation_id;
    private String service_name;
    @Column(name="userid")
    private String userId;
    private String role;
    private String operation_name;
    @Column(name="event_code")
    private String eventCode;
    @Column(name="processed_time")
    private LocalDateTime processedTime;
    private String additional_info;


    /* @Column(name="user_id")
     private String user_id;

     @Column(name="Correlation_id")
    private String correlation_id;
@Column(name="Service_name")
    private String service_name;

@Column(name="role")
    private String role;
@Column(name="operation_name")
    private String operation_name;
@Column(name="Eventcode")
    private EventCode eventCode;
@Column(name="Processed_time")
    private Timestamp processed_time;
@Column(name="additional_info")
    private String additional_Info;*/
}
