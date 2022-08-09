package sos.eu.service.accesscheckers;

import sos.eu.configuration.oauth.ResourceAccessChecker;
import sos.eu.service.models.PatientModelWithId;

public class PatientAccessChecker implements ResourceAccessChecker<String, PatientModelWithId> {

    @Override
    public boolean isAccessToResourceLegal(String s, PatientModelWithId patient) {
        return s.equals(patient.getName());
    }
}
