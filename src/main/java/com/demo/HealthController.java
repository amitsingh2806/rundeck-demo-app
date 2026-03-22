package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {

    @Value("${app.version:unknown}")
    private String appVersion;

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("version", appVersion);
        response.put("feature", "experimental-dashboard");
        return response;
    }

    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("app", "rundeck-demo-app");
        response.put("version", appVersion);
        response.put("status", "running");
        return response;
    }
}
