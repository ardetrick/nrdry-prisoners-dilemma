package com.nerdery.prisonersdilemma;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public class RatPrisoner implements Prisoner {

    @Override
    public boolean doesConfess(Interrogation interrogation) {
        return true;
    }
}
