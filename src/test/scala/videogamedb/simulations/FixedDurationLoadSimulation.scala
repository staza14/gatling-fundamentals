package videogamedb.simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class FixedDurationLoadSimulation extends Simulation {

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  def getAllVideoGames() = {
    exec(
      http("Get all video games")
        .get("/videogame")
    )
  }

  def getSpecificGame() = {
    exec(
      http("Get specific game")
        .get("/videogame/2")
    )
  }

  // 2 Scenario Definition
  val scn = scenario(name = "Fixed Duration Load Simulation")
    // this will make it run forever, and we will add something in our setup block to stop it
    .forever{
    exec(getAllVideoGames())
        .pause(5)
        .exec(getSpecificGame())
        .pause(5)
        .exec(getAllVideoGames())
    }

  // 3 Load Scenario
  setUp(
    scn.inject(
      // do nothing for 5 seconds
      nothingFor(5),
      atOnceUsers(users = 10),
      rampUsers(users = 20).during(30)
    ).protocols(httpProtocol)
  ).maxDuration(60) // add a max duration here, so gatling will stop the test after 60s
}
