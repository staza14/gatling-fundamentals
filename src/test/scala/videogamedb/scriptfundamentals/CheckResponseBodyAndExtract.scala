package videogamedb.scriptfundamentals
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyAndExtract extends Simulation{

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  // 2 Scenario Definition

  val scn = scenario(name = "Check with JSON Path")
    .exec(http("Get specific game")
    .get("/videogame/1")
    .check(jsonPath("$.name").is(expected = "Resident Evil 4" )))

  // lets now save a value to a val and then use it
  .exec(http("Get all video games")
  .get("/videogame")
  .check(jsonPath(path = "$[1].id").saveAs( key= "gameId")))
    // add some print lines to see whats going on
    .exec { session => println(session); session}

    .exec(http("Get specific game")
    .get("/videogame/#{gameId}")
    .check(jsonPath(path="$.name").is("Gran Turismo 3"))
    // lets get the response body and see what it looks like
    .check(bodyString.saveAs(key="responseBody")))
    .exec {session => println(session("responseBody").as[String]); session}

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
