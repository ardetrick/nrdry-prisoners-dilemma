package com.nerdery.prisonersdilemma

/**
  * @author Josh Klun (jklun@nerdery.com)
  */
case class Interrogation(partnerName: String,
                         partnerDiscipline: String,
                         partnerPreviousResponse: Option[Boolean],
                         playerPreviousResponse: Option[Boolean])
