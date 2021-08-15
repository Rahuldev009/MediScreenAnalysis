package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.dto.PatientNoteDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PatientNoteServiceTest {

    PatientNoteService patientNoteService;

    @Autowired
    public PatientNoteServiceTest(PatientNoteService patientNoteService) {
        this.patientNoteService = patientNoteService;
    }

    @Test
    void getPatientNotes() {
        List<PatientNoteDto> patientNoteDtoList = patientNoteService.getPatientNotes(1);
        Assert.assertTrue(patientNoteDtoList.size()>0);
    }

}