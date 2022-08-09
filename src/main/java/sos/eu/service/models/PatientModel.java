package sos.eu.service.models;

public class PatientModel {

    private String name;
    private Integer age;
    private Boolean sick;

    public PatientModel(String name, Integer age, Boolean sick) {
        this.name = name;
        this.age = age;
        this.sick = sick;
    }

    public String getName() {
        return name;
    }

    public Boolean getSick() {
        return sick;
    }

    public Integer getAge() {
        return age;
    }
}
