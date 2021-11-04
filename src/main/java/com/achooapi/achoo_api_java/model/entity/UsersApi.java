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
@Table(name = "UsersApi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class) // Generated CreatedDate & LastModifiedDate
public class UsersApi {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "user_id", columnDefinition = "NVARCHAR(255)")
    String name;

    @Column(name = "api_id", columnDefinition = "NVARCHAR(255)")
    String avatar;

    @Column(name = "password", columnDefinition = "NVARCHAR(255)")
    String password;

    @CreatedDate
    Date createdAt;
}
