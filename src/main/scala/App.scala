import com.nerdery.prisonersdilemma._
import com.typesafe.config.{Config, ConfigFactory}

object App {

  private val confess = "confess"
  private val silent = "silent"

  /**
    * This is a simple factory method for building the configured prisoner strategy. If the application is mis-configured, it will throw an
    * Exception.
    *
    * @return A new prisoner, matching the configuration of the application
    */
  private def buildPrisoner: Prisoner = {
    val config: Config = ConfigFactory.load
    config.getString("prisoner.strategy") match {
      case "silent" => new SilentPrisoner
      case "rat" => new RatPrisoner
      case "lamb" => new JvmSacrificialLambPrisoner
      // Add new prisoner strategies here.
      case strategy: Any => throw new Exception(s"Invalid or missing value for 'prisoner.strategy' in prisoners-dilemma.conf: $strategy")
    }
  }

  def main(args: Array[String]) {
    if (args.length < 2 || args.length > 4) {
      println("usage: java -jar prisoners-dilemma.jar <partnerName> <partnerDiscipline> [partnerPreviousResponse] [playerPreviousResponse]")
      System.exit(1)
    } else {
      def optionalArg(index: Int): Option[Boolean] = if (args.length > index) Some(args(index) == confess) else None
      println {
        if (buildPrisoner.doesConfess(Interrogation(args(0), args(1), optionalArg(2), optionalArg(3)))) confess else silent
      }
    }
  }
}
