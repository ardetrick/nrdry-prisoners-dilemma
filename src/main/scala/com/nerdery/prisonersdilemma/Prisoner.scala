package com.nerdery.prisonersdilemma

/**
  * The basic interface for a prisoner who can confess or remain silent.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
trait Prisoner {

  /**
    * Does the prisoner confess, with the given interrogation object?
    *
    * @param interrogation The interrogation that the prisoner is submitted to.
    * @return true to confess, false to remain silent
    */
  def doesConfess(interrogation: Interrogation): Boolean

}
