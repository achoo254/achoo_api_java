package com.achooapi.achoo_api_java.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Api")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class) // Generated CreatedDate & LastModifiedDate
public class Api {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    String name;

    @Column(name = "url", columnDefinition = "NVARCHAR(500)")
    String url;

    @Column(name = "body", columnDefinition = "NVARCHAR(4000)")
    String body;

    @Column(name = "subcribe", columnDefinition = "INT")
    int subcribe;

    @Column(name = "method_id", columnDefinition = "NVARCHAR(255)")
    String methodId;

    @Column(name = "collection_id", columnDefinition = "NVARCHAR(255)")
    String collectionId;

    @CreatedDate
    Date createdAt;

    @LastModifiedDate
    Date modifiedDate;
}
