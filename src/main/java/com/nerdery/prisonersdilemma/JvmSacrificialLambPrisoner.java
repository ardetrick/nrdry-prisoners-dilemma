package com.nerdery.prisonersdilemma;

/**
 * Created by Alex on 1/3/16.
 */
public class JvmSacrificialLambPrisoner implements Prisoner {

    @Override
    public boolean doesConfess(Interrogation interrogation) {
        // stay silent for everyone in team jvm, please exploit y'all!
        if (interrogation.partnerDiscipline().equalsIgnoreCase("jvm")) {
            return false;
        }
        return true;
    }

}
