package com.nerdery.prisonersdilemma

/**
  * A prisoner who always remains silent.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
class SilentPrisoner extends Prisoner {

  def doesConfess(interrogation: Interrogation): Boolean = false

}
