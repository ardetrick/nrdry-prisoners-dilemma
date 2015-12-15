package com.nerdery.prisonersdilemma

/**
  * @author Josh Klun (jklun@nerdery.com)
  */
class SilentPrisoner extends Prisoner {

  def doesConfess(interrogation: Interrogation): Boolean = false

}