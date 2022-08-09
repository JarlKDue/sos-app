package sos.eu.service.slas;

import sos.eu.configuration.slalogging.SLAChecker;

import java.util.Random;
/**
public class TimeslotSLAChecker implements SLAChecker<Timeslot> {
    
    Random random = new Random();

    @Override
    public boolean fulfillsSLA(Timeslot test) {
        return random.nextInt(9) > 2;
    }
}
 */
