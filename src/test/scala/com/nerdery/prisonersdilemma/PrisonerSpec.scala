package com.nerdery.prisonersdilemma

import org.scalatest.{Matchers, FreeSpec}

/**
  * A test that the basic Rat and Silent prisoner types behave properly in all cases.
  *
  * @author Josh Klun (jklun@nerdery.com)
  */
class PrisonerSpec extends FreeSpec with Matchers {
  "A Silent Prisoner" - {
    val prisoner = new SilentPrisoner
    def silentCheck(interrogation: Interrogation) = prisoner.doesConfess(interrogation) should be(false)
    def silentValidation(check: Interrogation => Unit, interrogation: Interrogation) = "remain silent" in { check(interrogation) }

    "with no prior results" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", None, None))
    }

    "with matching prior confessions" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", Some(true), Some(true)))
    }

    "with matching prior silence" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", Some(true), Some(true)))
    }

    "with prior partner betrayal" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", Some(false), Some(true)))
    }

    "with prior player betrayal" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", Some(true), Some(false)))
    }
  }

  "A Rat Prisoner" - {
    val prisoner = new RatPrisoner
    def confessionCheck(interrogation: Interrogation) = prisoner.doesConfess(interrogation) should be(true)
    def confessionValidation(check: Interrogation => Unit, interrogation: Interrogation) = "confess" in { check(interrogation) }

    "with no prior results" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "jvm", None, None))
    }

    "with matching prior confessions" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "jvm", Some(true), Some(true)))
    }

    "with matching prior silence" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "jvm", Some(true), Some(true)))
    }

    "with prior partner betrayal" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "jvm", Some(false), Some(true)))
    }

    "with prior player betrayal" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "jvm", Some(true), Some(false)))
    }
  }

  "A JVM Sacrificial Lamb Prisoner" - {
    val prisoner = new JvmSacrificialLambPrisoner
    def silentCheck(interrogation: Interrogation) = prisoner.doesConfess(interrogation) should be(false)
    def silentValidation(check: Interrogation => Unit, interrogation: Interrogation) = "remain silent" in { check(interrogation) }
    def confessionCheck(interrogation: Interrogation) = prisoner.doesConfess(interrogation) should be(true)
    def confessionValidation(check: Interrogation => Unit, interrogation: Interrogation) = "confess" in { check(interrogation) }

    "not from jvm" - {
      confessionValidation(confessionCheck, Interrogation("jdoe", "php", None, None))
    }

    "from jvm" - {
      silentValidation(silentCheck, Interrogation("jdoe", "jvm", None, None))
    }
  }

}
