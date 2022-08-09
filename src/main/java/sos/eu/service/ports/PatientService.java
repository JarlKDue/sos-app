package sos.eu.service.ports;

import sos.eu.service.models.PatientModel;

import java.util.List;

public interface PatientService {

    PatientModel getPatientById(Long patientId);
    PatientModel updatePatientById(Long patientId, PatientModel patientModel);
    PatientModel createPatient(PatientModel patientModel);

    String initDB();

    List<PatientModel> getAllPatients();
}
