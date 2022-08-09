package sos.eu.configuration.slalogging;

//TODO Expand with SLAName, Log Statement, Etc
public interface SLAChecker<ItemToCheck> {
    boolean fulfillsSLA(ItemToCheck itemToCheck);
}
