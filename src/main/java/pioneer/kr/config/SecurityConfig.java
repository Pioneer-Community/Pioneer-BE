// src/main/java/pioneer/kr/config/SecurityConfig.java
package pioneer.kr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/hello").permitAll() // 인증 없이 접근 가능
                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
                )
                .formLogin(login -> login
                        .loginPage("/login") // 로그인 페이지를 커스터마이즈할 수 있음 (현재 비활성화 상태일 수도)
                        .permitAll()  // 모든 사용자에게 로그인 페이지를 허용
                        .disable())  // 로그인 폼 비활성화
                .httpBasic(basic -> basic.disable()); // HTTP Basic 인증 비활성화

        return http.build();
    }
}
