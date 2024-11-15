package com.example.lasttest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "users")  // DB 테이블명 users
@Getter
@Setter
@NoArgsConstructor       // 기본 생성자
@AllArgsConstructor      // 모든 필드를 받는 생성자
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "create_at", updatable = false)
    private Timestamp createAt;
}