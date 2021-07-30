package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.controller.dto.PatientDto;
import com.example.MediScreenAnalysis.controller.dto.PatientNoteDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class ReportServiceImplTest {

    @InjectMocks
    ReportServiceImpl reportService;

    @Mock
    PatientInfoService patientInfoService;

    @Mock
    PatientNoteService patientNoteService;

    @Test
    void countTriggerWords() {
        PatientNoteDto patientNoteDto1 = new PatientNoteDto();
        patientNoteDto1.setPatId(21);
        patientNoteDto1.setNote("Hemoglobin A1C");
        PatientNoteDto patientNoteDto2 = new PatientNoteDto();
        patientNoteDto2.setPatId(21);
        patientNoteDto2.setNote("Microalbumin");
        List<PatientNoteDto> patientNoteDtoList = new ArrayList<>();
        patientNoteDtoList.add(patientNoteDto1);
        patientNoteDtoList.add(patientNoteDto2);
        Mockito.when(patientNoteService.getPatientNotes(21)).thenReturn(patientNoteDtoList);
        Assert.assertEquals(2, reportService.countTriggerWords(21));
    }

    @Test
    void getReport() {
        PatientDto patientDto = new PatientDto();
        patientDto.setId(21);
        patientDto.setPatientName("Test1");
        patientDto.setFamilyName("TestFamily1");
        patientDto.setSex("M");
        patientDto.setDateOfBirth("1957-08-08");
        Mockito.when(patientInfoService.getPatientInfo(21)).thenReturn(patientDto);
        Assert.assertEquals(63, reportService.getReport(21).getAge());
    }

}