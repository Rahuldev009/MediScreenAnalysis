package com.example.MediScreenAnalysis.controller;

import com.example.MediScreenAnalysis.model.PatientReport;
import com.example.MediScreenAnalysis.service.ReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MediScreenAnalysisController {
    private Logger logger = LoggerFactory.getLogger(MediScreenAnalysisController.class);
    private ReportService reportService;

    @Autowired
    public MediScreenAnalysisController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/assess/id")
    public String report(@RequestParam int patId) {
        PatientReport patientReport = reportService.getReport(patId);
        logger.info("patient report "+patientReport.toString());
        return "Patient: Test Test"+patientReport.getThreat()+" (age "+patientReport.getAge()+") " +
                "diabetes assessment is: "+patientReport.getThreat();
    }

    @GetMapping("/")
    public ModelAndView home(PatientReport patientReport) {
        logger.info("Home page of patient report ");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("patientReport", patientReport);
        modelAndView.setViewName("report/report");
        return modelAndView;
    }

    @PostMapping("/generateReport")
    public ModelAndView generateReport(int id) {
        ModelAndView modelAndView = new ModelAndView();
        PatientReport patientReport = reportService.getReport(id);
        logger.info("patient report "+patientReport.toString());
        modelAndView.addObject("patientReport", patientReport);
        modelAndView.setViewName("report/generateReport");
        return modelAndView;
    }

}
