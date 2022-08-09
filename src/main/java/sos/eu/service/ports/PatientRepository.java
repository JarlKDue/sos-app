package sos.eu.service.ports;

import sos.eu.service.models.PatientModelWithId;

public interface PatientRepository {

    PatientModelWithId  getPatientById(Long id);

}
