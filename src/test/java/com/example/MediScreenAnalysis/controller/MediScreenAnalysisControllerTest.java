package com.example.MediScreenAnalysis.controller;

import com.example.MediScreenAnalysis.model.PatientReport;
import com.example.MediScreenAnalysis.service.ReportService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MediScreenAnalysisControllerTest {

    @Mock
    ReportService reportService;

    @InjectMocks
   MediScreenAnalysisController mediScreenAnalysisController;

    @Mock
    Model model;

    @Test
    void report() {
        PatientReport patientReport = new PatientReport();
        patientReport.setId(21);
        patientReport.setThreat("Borderline");
        patientReport.setAge(50);
        Mockito.when(reportService.getReport(21)).thenReturn(patientReport);
        String s = mediScreenAnalysisController.report(21);
        Assert.assertEquals("Patient: Test TestBorderline (age 50) diabetes assessment is: Borderline", s);
    }

    @Test
    void home() {
        PatientReport patientReport = new PatientReport();
        ModelAndView modelAndView = mediScreenAnalysisController.home(patientReport);
        Assert.assertEquals("report/report", modelAndView.getViewName());
    }

    @Test
    void generateReport() {
        PatientReport patientReport = new PatientReport();
        patientReport.setId(21);
        patientReport.setThreat("Borderline");
        patientReport.setAge(50);
        Mockito.when(reportService.getReport(21)).thenReturn(patientReport);
        ModelAndView modelAndView = mediScreenAnalysisController.generateReport(21);
        Assert.assertEquals("report/generateReport", modelAndView.getViewName());
    }

}