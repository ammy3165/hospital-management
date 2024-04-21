package com.amrendra.hospitalmanagement.Controller;

import com.amrendra.hospitalmanagement.Response.DiseaseContactResponse;
import com.amrendra.hospitalmanagement.Response.DiseaseDataResponse;
import com.amrendra.hospitalmanagement.Service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/diseaseData/{loc}")
    public DiseaseDataResponse getDiseaseDataByLocation(@PathVariable String loc){
        return diseaseService.fetchDiseaseDataByLocation(loc);
    }

    @GetMapping("diseaseContact/contact")
    public DiseaseContactResponse getDiseaseContactHelpline(@PathVariable String loc){
       return diseaseService.fetchDiseaseContactHelpline(loc);
    }

}
