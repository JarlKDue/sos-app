package sos.eu.service.models;

public class PatientModelWithId extends PatientModel{

    private Long id;
    
    public PatientModelWithId(String name, Integer age, Boolean sick, Long id) {
        super(name, age, sick);
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
