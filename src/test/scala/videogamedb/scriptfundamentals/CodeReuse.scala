package videogamedb.scriptfundamentals
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CodeReuse extends Simulation {
  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  // create some reusable methods

  def getAllVideoGames() = {
    // if we want this to repeat a number of times we can add a reuse block
    repeat(times = 3) {
      exec(http(requestName = "Get all video games")
        .get("/videogame")
        .check(status.is(expected = 200)))
    }
  }

  def getSpecificGame() = {
    // we can add another variable to repeat, a counter name
    repeat(times = 5, counterName = "counter") {
      // we can use this counter in here
      exec(http(requestName = "Get specific game with id: #{counter}")
        .get("/videogame/#{counter}")
        .check(status.in(expected = 200 to 210)))
    }
  }

  // 2 Scenario Definition
  val scn = scenario(name = "Code Reuse")
    .exec(getAllVideoGames())
    .pause(duration = 5)
    .exec(getSpecificGame())
    .pause(duration = 5)
    // could also add repeat block here this way:
    .repeat(times = 2) {
      getAllVideoGames()
    }

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
