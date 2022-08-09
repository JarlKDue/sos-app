package sos.eu.service;

import sos.eu.service.models.PatientModel;
import sos.eu.service.ports.PatientService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class PatientServiceImpl implements PatientService {

    Random random = new Random();

    public PatientServiceImpl() {

    }

    @Override
    public PatientModel getPatientById(Long patientId) {
        return new PatientModel("Yes", 23, true);
    }

    @Override
    public PatientModel updatePatientById(Long patientId, PatientModel patientModel) {
        return new PatientModel("Yes", 23, true);
    }

    @Override
    public String initDB() {
        return "null";
    }

    @Override
    public List<PatientModel> getAllPatients() {
        return null;
    }
//
//    @Override
//    @SecuredResource(resourceAccessChecker = PatientAccessChecker.class)
//    public PatientModel getPatientById(Long patientId) {
//        return caseOutbound.getPatientById(patientId);
//    }
//
//    @Override
//    public PatientModel updatePatientById(Long patientId, PatientModel patientModel) {
//        PatientModel modelToUpdate = getPatientById(patientId);
//        return new PatientModel("alice", 22, false);
//    }
//
//    @Override
//    public String initDB() {
//        return caseOutbound.initDB();
//    }
//
//    @SLARule(slaChecker = CaseBookingSLAChecker.class, slaName = "book_case_sla")
//    public CaseModel bookCase(Long patientId){
//        CaseModel caseModel = caseOutbound.bookCase(patientId);
//        mockSLAS();
//        timeSlotSLA();
//        return caseModel;
//    }
//
//    @SLARule(slaChecker = TestSlaChecker.class, slaName = "mock_example_sla")
//    public String mockSLAS(){
//        if(random.nextInt(10) < 3){
//            return "Mello";
//        }
//        return "Hello";
//    }
//
//    @SLARule(slaChecker = TimeslotSLAChecker.class, slaName = "mock_timeslot_not_available_sla")
//    public Timeslot timeSlotSLA(){
//        Timeslot timeslot = new Timeslot(LocalDate.now());
//        return timeslot;
//    }
//
//    //TODO Make this occasionally fail to find patient or treater.
//    @SLARule(slaChecker = CaseBookingSLAChecker.class, slaName = "create_case_sla")
//    public CaseModel createCaseModel(Long patientId, Long treaterId){
////        Set<Short> s = new HashSet<>();
////        for (short i = 0; i < 100; i++) {
////            s.add(i);
////            s.remove(i - 1);
////        }
////        System.out.println(s.size());
//        String x = null;
//        System.out.println(x.toString());
//          return null;
////        CaseModel caseModel = new CaseModel(null, null);
////        return caseModel;
//    }
//
//    @AuditLog(getAudittedAction = "getting_all_cases_for_treater")
//    public List<CaseModel> getAllCaseModelsForTreater(Long treaterId){
//        return caseOutbound.getAllCasesByTreaterId(treaterId);
//    }

    @Override
    public PatientModel createPatient(PatientModel patientModel) {
        // TODO Auto-generated method stub
        return null;
    }


}
