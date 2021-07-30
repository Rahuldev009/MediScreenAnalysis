package com.example.MediScreenAnalysis.utils;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void calculateAge() {
       int age = Utilities.calculateAge("2020-01-01");
        Assert.assertEquals(1, age);
    }
}