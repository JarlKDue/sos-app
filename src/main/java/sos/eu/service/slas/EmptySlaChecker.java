package sos.eu.service.slas;

import sos.eu.configuration.slalogging.SLAChecker;

public class EmptySlaChecker implements SLAChecker {
    @Override
    public boolean fulfillsSLA(Object test) {
        return false;
    }
}
