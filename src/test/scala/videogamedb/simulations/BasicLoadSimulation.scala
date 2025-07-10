package videogamedb.simulations
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicLoadSimulation extends Simulation{

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
  val scn = scenario(name = "Basic Load Simulation")
    .exec(getAllVideoGames())
    .pause(5)
    .exec(getSpecificGame())
    .pause(5)
    .exec(getAllVideoGames())

  // 3 Load Scenario
  setUp(
  scn.inject(
    // do nothing for 5 seconds
    nothingFor(5),
    atOnceUsers(users = 5),
    // ramp up users over a given amount of time - 10 seconds
    rampUsers(users = 10).during(10)
  ).protocols(httpProtocol)
  )
}
