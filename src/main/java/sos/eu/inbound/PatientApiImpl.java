package sos.eu.inbound;

import generated.Patient;
import sos.eu.service.ports.PatientService;
import javax.ws.rs.core.Response;

public class PatientApiImpl implements generated.PatientsApi {

    private final PatientService patientService;

    public PatientApiImpl(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public Response patientsGet() {
        patientService.getAllPatients();
        return null;
    }

    @Override
    public Response patientsPost(Patient patient) {
        return null;
    }

    @Override
    public Response getPatientById(Integer id) {
        // TODO Auto-generated method stub
        Patient patient = new Patient();
        patient.setAge(22);
        patient.setName("Mark");
        patient.setSick(false);
        return Response.ok(patient).build();
    }

    @Override
    public Response updatePatientById(Integer id, Patient patient) {
        // TODO Auto-generated method stub
        return null;
    }
}
