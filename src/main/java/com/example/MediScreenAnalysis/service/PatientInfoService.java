package com.example.MediScreenAnalysis.service;

import com.example.MediScreenAnalysis.dto.PatientDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PatientInfoService {

    public PatientDto getPatientInfo(int id) {
        WebClient.Builder webClientBuilder = WebClient.builder();
        String JsonResponseFrom = webClientBuilder.build()
                .get()
                .uri("http://patients:8081/getPatientInfo?id=" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        Gson gson = new Gson();
        return gson.fromJson(JsonResponseFrom, PatientDto.class);
    }

}
