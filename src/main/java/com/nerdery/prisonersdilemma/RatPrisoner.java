package com.nerdery.prisonersdilemma;

/**
 * A prisoner who always confesses.
 *
 * @author Josh Klun (jklun@nerdery.com)
 */
public class RatPrisoner implements Prisoner {

    @Override
    public boolean doesConfess(Interrogation interrogation) {
        return true;
    }
}
