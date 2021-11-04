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
@Table(name = "Users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EntityListeners(AuditingEntityListener.class) // Generated CreatedDate & LastModifiedDate
public class Users {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "name", columnDefinition = "NVARCHAR(255)")
    String name;

    @Column(name = "avatar", columnDefinition = "NVARCHAR(1000)")
    String avatar;

    @Column(name = "email", columnDefinition = "NVARCHAR(255)")
    String email;

    @Column(name = "password", columnDefinition = "NVARCHAR(255)")
    String password;

    @CreatedDate
    Date createdAt;
}
