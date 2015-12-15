package com.nerdery.prisonersdilemma

/**
  * The details of an interrogation that a prisoner undergoes, including the name of their partner, the discipline of their partner,
  * their partner's previous response (if any) and their previous response (if any).
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
case class Interrogation(partnerName: String,
                         partnerDiscipline: String,
                         partnerPreviousResponse: Option[Boolean],
                         playerPreviousResponse: Option[Boolean])
