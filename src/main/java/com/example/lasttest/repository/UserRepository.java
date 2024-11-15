package com.example.lasttest.repository;

import com.example.lasttest.model.UserModel;  // 엔티티 UserModel을 import
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    // 필요에 따라 커스텀 쿼리 메서드를 정의할 수 있습니다.
    // 예: findByEmail(String email);
}