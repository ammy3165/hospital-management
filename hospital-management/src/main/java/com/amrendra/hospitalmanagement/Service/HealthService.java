package com.amrendra.hospitalmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthService {

    public String getHealthStatus(int age, String gender, String disease) {

        return "Health status";
    }
}
