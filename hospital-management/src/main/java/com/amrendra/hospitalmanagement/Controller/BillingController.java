package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Exception.oneToOneException;
import com.amrendra.hospitalmanagement.Request.BillingRequest;
import com.amrendra.hospitalmanagement.Service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/generate/Bill")
    public String generateBill(@RequestBody BillingRequest billingRequest) throws oneToOneException {
        Double amount=billingService.generateBill(billingRequest);
        return "Bill generated. Amount to be paid:Rs "+amount;
    }
}
