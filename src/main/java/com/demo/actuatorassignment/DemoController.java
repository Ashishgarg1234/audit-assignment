package com.demo.actuatorassignment;

import com.demo.actuatorassignment.dto.AuditResponse;
import com.demo.actuatorassignment.dto.HttpTrace;
import com.demo.actuatorassignment.dto.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DemoController {
    @Autowired
    RestTemplate restTemplate;
    AuditResponse auditResponse;
    @GetMapping("/ping")
    public Status getHealth()
    {
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        Status status=restTemplate.getForObject(baseUrl + "/actuator/health",Status.class);
        return status;
    }

    @GetMapping("/audit")
    public AuditResponse getAudit()
    {
        auditResponse=new AuditResponse();
        String baseUrl =
                ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        HttpTrace httpTrace =restTemplate.getForObject(baseUrl + "/actuator/httptrace", HttpTrace.class);
        httpTrace.getTraces().forEach(x->auditResponse.addTrace(x));
        return auditResponse;
    }

}
