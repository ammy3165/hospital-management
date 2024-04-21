package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class HealthController {
   @Autowired
    private HealthService healthService;

   @GetMapping("/health")
   public String getHealthStatus(@RequestParam int age, @RequestParam String gender,
                                                @RequestParam String disease ){
       return healthService.getHealthStatus(age,gender,disease);
   }
}
