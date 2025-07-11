package videogamedb.finalsimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class VideoGameFullTest extends Simulation{

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader(value = "application/json")

  // create a simulation that has runtime parameters:
  // 1. users
  // 2. ramp up time
  // 3. test duration

  // variables for the feeders and runtime

  def USERCOUNT = System.getProperty("USERS", "5").toInt
  def RAMPDURATION = System.getProperty("RAMP_DURATION", "10").toInt
  def TESTDURATION: Int = System.getProperty("TEST_DURATION", "30").toInt

  val csvFeeder = csv("data/gameCsvFile.csv").random

  before {
    println(s"Running test with ${USERCOUNT} users")
    println(s"Ramping users over ${RAMPDURATION} seconds")
    println(s"Total test duration: ${TESTDURATION} seconds")
  }

  // http methods
  def getAllVideoGames() = {
    exec(
      http("Get all video games")
        .get("/videogame")
        .check(status.is(expected = 200))
    )
  }

  def authenticate() = {
    exec(http("Authenticate")
      .post("/authenticate")
      .body(StringBody("{\n  \"password\": \"admin\",\n  \"username\": \"admin\"\n}"))
      .check(jsonPath("$.token").saveAs("jwtToken")))
  }

  def createNewGame() = {
    feed(csvFeeder)
      .exec(http("Create New Game - #{gameName}")
        .post("/videogame")
        .header("authorization", "Bearer #{jwtToken}")
        .body(ElFileBody("bodies/newGameTemplate.json")).asJson)
  }

  def getSingleGame() = {
    exec(http("Get single game - #{gameName}")
      .get("/videogame/#{gameId}")
      .check(jsonPath("$.name").is("#{gameName}")))
  }

  def deleteGame() = {
    exec(http("Delete game - #{gameName}")
      .delete("/videogame/#{gameId}")
      .header("authorization", "Bearer #{jwtToken}")
      .check(bodyString.is("Video game deleted")))
  }
  // 2 Scenario Definition
  // using https calls, create a scenario that does the following:
  // 1. get all games
  // 2. create a new game ( authenticate)
  // 3. get details of a single game
  // 4. delete a game

  val scn = scenario(name = "Video Game Full Test")
    .forever {
      exec(getAllVideoGames())
        .pause(2)
        .exec(authenticate())
        .pause(2)
        .exec(createNewGame())
        .pause(2)
        .exec(getSingleGame())
        .pause(2)
        .exec(deleteGame())
    }
  // 3 Load Scenario

  // Have a feeder to generate the json for creating a new game


  // add a before and after block

  setUp(
    scn.inject(
      nothingFor(5),
      rampUsers(USERCOUNT).during(RAMPDURATION)
    ).protocols(httpProtocol)
  ).maxDuration(TESTDURATION)

  after {
    println("Stress test completed")
  }
}
