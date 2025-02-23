package pioneer.kr.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")  // 기본 경로를 "/api"로 설정
public class ExampleController {
    @GetMapping("/hello")  // "/api/hello" 경로 매핑
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
