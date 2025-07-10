package videogamedb.feeders
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class CsvFeeder extends Simulation{

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  // circular strategy, goes through entries one after another and then back around
  val csvFeeder = csv( filePath = "data/gameCsvFile.csv").circular

  // create our reusable methods

  def getSpecifcVideoGame() = {
    repeat(10) {
      feed(csvFeeder)
        .exec(http("Get video game with name - #{gameName}")
          .get("/videogame/#{gameId}")
          .check(jsonPath("$.name").is("#{gameName}"))
          .check(status.is(200)))
        .pause(1)
    }
  }
  // 2 Scenario Definition
  val scn = scenario(name = "CSV feeder test")
    .exec(getSpecifcVideoGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
