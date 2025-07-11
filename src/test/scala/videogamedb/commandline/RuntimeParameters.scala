package videogamedb.commandline
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class RuntimeParameters extends Simulation {

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  def getAllVideoGames() = {
    exec(
      http("Get all video games")
        .get("/videogame")
    ).pause(1)
  }
  // 2 Scenario Definition
  val scn = scenario("Run from command line")
    .forever {
      exec(getAllVideoGames())
    }

  // 3 Load Scenario
  setUp(
    scn.inject(
      // do nothing for 5 seconds
      nothingFor(5),
      rampUsers(users = 10).during(20)
    ).protocols(httpProtocol)
  ).maxDuration(duration = 20)
}
