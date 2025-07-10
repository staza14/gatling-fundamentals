package videogamedb.scriptfundamentals
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CodeReuse extends Simulation {
  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  // create some reusable methods

  def getAllVideoGames() = {
    exec(http(requestName = "Get all video games")
    .get("/videogame")
    .check(status.is(expected = 200)))
  }

  def getSpecificGame() = {
    exec(http(requestName = "Get specific game")
      .get("/videogame/1")
      .check(status.in(expected = 200 to 210)))
  }

  // 2 Scenario Definition
  val scn = scenario(name = "Code Reuse")
    .exec(getAllVideoGames())
    .pause(duration = 5)
    .exec(getSpecificGame())
    .pause(duration = 5)
    .exec(getAllVideoGames())
  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
