package com.achooapi.achoo_api_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Header")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class) // Generated CreatedDate & LastModifiedDate
public class Header {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "header_key", columnDefinition = "NVARCHAR(255)")
    String headerKey;

    @Column(name = "header_value", columnDefinition = "NVARCHAR(1000)")
    String headerValue;

    @Column(name = "api_id", columnDefinition = "NVARCHAR(255)")
    String apiId;

    @CreatedDate
    Date createdAt;
}
