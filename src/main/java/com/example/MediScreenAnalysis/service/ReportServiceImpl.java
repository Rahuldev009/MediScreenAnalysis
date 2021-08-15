package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.dto.PatientDto;
import com.example.MediScreenAnalysis.dto.PatientNoteDto;
import com.example.MediScreenAnalysis.model.PatientReport;
import com.example.MediScreenAnalysis.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private PatientNoteService patientNoteService;
    private PatientInfoService patientInfoService;

    @Autowired
    public ReportServiceImpl(PatientInfoService patientInfoService, PatientNoteService patientNoteService) {
        this.patientInfoService = patientInfoService;
        this.patientNoteService = patientNoteService;
    }
    
    List<String> symptoms = Arrays.asList("Hemoglobin A1C", "Microalbumin", "Body Height",
            "Body Weight", "Smoker", "Abnormal", "Cholesterol", "Dizziness", "Relapse", "Reaction",
            "Antibodies");

    @Override
    public int countTriggerWords(int patId) {
        int triggerWords = 0;
        List<PatientNoteDto> patientNoteDtoList = patientNoteService.getPatientNotes(patId);
        for (int i = 0; i < patientNoteDtoList.size(); i++) {
            for (int j = 0; j < symptoms.size(); j++) {
                if (patientNoteDtoList.get(i).getNote().contains(symptoms.get(j))) {
                    triggerWords++;
                    break;
                }
            }
        }
        return triggerWords;
    }

    @Override
    public PatientReport getReport(int patId) {
        PatientReport patientReport = new PatientReport();
        PatientDto patientDto = patientInfoService.getPatientInfo(patId);
        int age = Utilities.calculateAge(patientDto.getDateOfBirth());
        int triggerWords = countTriggerWords(patId);
        String sex = patientDto.getSex();
        String threat;
        if (triggerWords < 2) {
            threat = "None";
        } else if (triggerWords <= 4 && age >= 30) {
            threat = "Borderline";
        } else if (triggerWords == 3 && age < 30 && sex == "M") {
            threat = "In Danger";
        } else if (triggerWords == 4 && age < 30 && sex == "F") {
            threat = "In Danger";
        } else if (triggerWords <= 7 && age >= 30) {
            threat = "In Danger";
        } else if (triggerWords == 6 && age < 30) {
            threat = "Borderline";
        } else if (triggerWords == 5 && age < 30 && sex == "M") {
            threat = "Early Onset";
        } else if (triggerWords == 7 && age < 30 && sex == "F") {
            threat = "Early Onset";
        } else if (triggerWords >= 8 && age >= 30) {
            threat = "Early Onset";
        } else {
            threat = "Something went wrong";
        }
        patientReport.setId(patId);
        patientReport.setAge(age);
        patientReport.setThreat(threat);
        return patientReport;
    }

}
