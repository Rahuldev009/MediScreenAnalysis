package com.example.MediScreenAnalysis.model;

public class PatientReport {

    int id;
    int age ;
    String threat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getThreat() {
        return threat;
    }

    public void setThreat(String threat) {
        this.threat = threat;
    }

    @Override
    public String toString() {
        return "PatientReport{" +
                "id=" + id +
                ", age=" + age +
                ", threat='" + threat + '\'' +
                '}';
    }
}
