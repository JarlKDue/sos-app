package sos.eu.service.slas;

import sos.eu.configuration.slalogging.SLAChecker;

public class TestSlaChecker implements SLAChecker<String> {

    @Override
    public boolean fulfillsSLA(String test){
        return test.equals("Hello");
    }
}
