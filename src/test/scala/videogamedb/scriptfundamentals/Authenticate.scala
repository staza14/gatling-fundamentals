package videogamedb.scriptfundamentals
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Authenticate extends Simulation{

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader(value = "application/json")
  // create reusable methods
  def authenticate() = {
    exec(http("Authenticate")
      .post("/authenticate")
      .body(StringBody("{\n  \"password\": \"admin\",\n  \"username\": \"admin\"\n}"))
      .check(jsonPath("$.token").saveAs("jwtToken")))
  }

  def createNewGame() = {
    exec(http("Create new game")
      .post("/videogame")
      .header("Authorization", "Bearer #{jwtToken}")
      .body(StringBody(
        "{\n  \"category\": \"Platform\",\n  \"name\": \"Mario\",\n  \"rating\": \"Mature\",\n  \"releaseDate\": \"2012-05-04\",\n  \"reviewScore\": 85\n}"
      )))
  }
  // 2 Scenario Definition
  val scn = scenario(name = "Authenticate")
    .exec(authenticate())
    .exec(createNewGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
