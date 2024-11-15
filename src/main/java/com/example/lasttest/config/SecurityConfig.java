//package com.example.lasttest.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//
//import java.util.Collections;
//
//@Configuration
//public class SecurityConfig {
//
//    // Spring Security 설정을 위한 메소드
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))  // CORS 설정 적용
//                .csrf(csrf -> csrf.disable())  // CSRF 비활성화 (AbstractHttpConfigurer::disable 사용)
//                .authorizeHttpRequests(authorizeRequests ->
//                        authorizeRequests
//                                .anyRequest().permitAll()  // 모든 요청에 대해 인증 없이 접근 허용
//                );
//
//        return http.build();  // Spring Security 설정이 끝나면 http.build()로 마무리
//    }
//
//    // CORS 설정을 커스터마이징하는 CorsConfigurationSource 구현
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        // 허용할 Origins
//        configuration.setAllowedOrigins(Collections.singletonList("*"));  // 리액트 앱의 IP
//        // 허용할 HTTP 메서드
//        configuration.setAllowedMethods(Collections.singletonList("*"));  // 모든 HTTP 메서드 허용
//        // 허용할 헤더
//        configuration.setAllowedHeaders(Collections.singletonList("*"));  // 모든 헤더 허용
//        // 자격증명 허용
//        configuration.setAllowCredentials(true);
//        // Pre-flight 요청에 대한 응답을 캐시할 시간
//        configuration.setMaxAge(3600L);  // 1시간 동안 캐시
//        // 응답 헤더에 포함할 헤더
//        configuration.setExposedHeaders(Collections.singletonList("Authorization"));
//
//        // CorsConfigurationSource는 CORS 설정을 요청에 맞게 반환
//        return request -> configuration;
//    }
//
//    // 전역 CORS 설정 (Spring MVC에서 적용되는 CORS 설정)
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                // 모든 경로에 대해 CORS 설정 적용
//                registry.addMapping("/**")  // 모든 경로에 대해 CORS 설정
//                        .allowedOrigins("http://localhost:3000")
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 허용할 메서드들
//                        .allowedHeaders("*")  // 모든 헤더 허용
//                        .allowCredentials(true);  // 자격증명 허용
//            }
//        };
//    }
//}