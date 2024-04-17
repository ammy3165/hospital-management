package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Request.AppointmentRequest;
import com.amrendra.hospitalmanagement.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping
public class AppointmentController {
    @Autowired
    private AppointmentService appointService;

    @PostMapping("/addAppointment")
    public String addAppointment(@RequestBody AppointmentRequest appointmentRequest)
                                                                throws ParseException {
        appointService.addAppointment(appointmentRequest);
       return "appointment scheduled";
    }
}
