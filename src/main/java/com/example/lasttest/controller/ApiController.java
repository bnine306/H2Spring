package com.example.lasttest.controller;

import com.example.lasttest.dto.UserDto;
import com.example.lasttest.model.UserModel;
import com.example.lasttest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://115.68.179.98:3000")  // React 앱의 주소를 설정
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<UserModel> users = userRepository.findAll();  // DB에서 모든 사용자 정보 조회

        if (users.isEmpty()) {
            System.out.println("No users found in the database.");
        } else {
            System.out.println("Retrieved users: " + users);
        }
        return users.stream().map(user -> new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreateAt()
        )).collect(Collectors.toList());  // UserDto로 변환하여 리턴
    }
}