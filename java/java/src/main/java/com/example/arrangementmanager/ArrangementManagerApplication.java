package com.example.arrangementmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ArrangementManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArrangementManagerApplication.class, args);
    }
}

@RestController
@RequestMapping("/v1/arrangements")
class ArrangementController {
    
    @GetMapping
    public List<Arrangement> getArrangements() {
        return Arrays.asList(
            new Arrangement("ARR-1001", "LOAN", "ACTIVE"),
            new Arrangement("ARR-1002", "ACCOUNT", "CLOSED")
        );
    }
    
    record Arrangement(String id, String type, String status) {}
}