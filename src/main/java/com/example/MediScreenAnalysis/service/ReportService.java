package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.model.PatientReport;

public interface ReportService {

    int countTriggerWords(int patId);

    PatientReport getReport(int patId);

}
