package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.controller.dto.PatientNoteDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class PatientNoteService {
    public List<PatientNoteDto> getPatientNotes(int patId) {
        WebClient.Builder webClientBuilder = WebClient.builder();
        String JsonResponseFrom = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/getPatientNotes?patId=" + patId)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        Gson gson = new Gson();
        List<PatientNoteDto> patientNoteList = gson.fromJson(JsonResponseFrom,
                new TypeToken<List<PatientNoteDto>>() {
                }.getType());
        return patientNoteList;
    }
}
