package com.nerdery.prisonersdilemma

/**
  * @author Josh Klun (jklun@nerdery.com)
  */
trait Prisoner {

  def doesConfess(interrogation: Interrogation): Boolean

}
