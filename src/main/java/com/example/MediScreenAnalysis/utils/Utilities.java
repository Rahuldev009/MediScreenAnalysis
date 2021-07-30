package com.example.MediScreenAnalysis.utils;


import java.time.LocalDate;
import java.time.Period;

public class Utilities {
    public static int calculateAge(String birthdate){
        LocalDate currDate = LocalDate.now();
        LocalDate localDate = LocalDate.parse(birthdate);
        int age = Period.between(localDate,currDate).getYears();
        return age;
    }
}
