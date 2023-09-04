package com.example.testammper.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Table(name = "users", schema = "public", catalog = "postgres")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @Basic
    @Column(name = "lastname", nullable = true, length = 100)
    private String lastname;
    @Basic
    @Column(name = "username", nullable = false, length = 15)
    private String username;
    @Basic
    @Column(name = "pass", nullable = false, length = -1)
    private String pass;
    @Basic
    @Column(name = "created_at", nullable = true)
    private Date createdAt;
    @Basic
    @Column(name = "active", nullable = true)
    private Boolean active;
}
