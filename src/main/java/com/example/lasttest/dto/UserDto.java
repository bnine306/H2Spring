package com.example.lasttest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor      // 모든 필드를 받는 생성자
@Getter                 // 모든 필드에 대해 getter 메서드 자동 생성
@Setter                 // 모든 필드에 대해 setter 메서드 자동 생성
public class UserDto {

    private Long id;
    private String name;
    private String email;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp createAt;
}