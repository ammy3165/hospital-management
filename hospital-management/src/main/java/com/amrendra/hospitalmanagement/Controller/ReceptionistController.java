package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Exception.ValidationException;
import com.amrendra.hospitalmanagement.Request.ReceptionistRequest;
import com.amrendra.hospitalmanagement.Response.ReceptionistResponse;
import com.amrendra.hospitalmanagement.Service.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Receptionist")
public class ReceptionistController {
    @Autowired
    private ReceptionistService receptionistService;

    @PostMapping("/login")
    public ReceptionistResponse LogInReceptionist(@RequestBody ReceptionistRequest receptionistRequest)
                                                                             throws ValidationException {
      return receptionistService.logInReceptionist(receptionistRequest);
    }
    @GetMapping("get/due")
    public String getBillDetails(@RequestParam String patientPhone ){
        Double amount=receptionistService.getBillDetails(patientPhone);
        return ("Amount due:Rs."+amount);
    }
    @PutMapping("/clear/due")
    public String clearDues(@RequestParam String patientPhone ){
        receptionistService.clearDues(patientPhone);
        return ("Dues cleared");
    }
}
