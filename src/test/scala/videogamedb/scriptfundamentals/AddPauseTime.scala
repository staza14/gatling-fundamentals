package videogamedb.scriptfundamentals
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.recorder.internal.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration.milliseconds

class AddPauseTime extends Simulation {

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")

  // 2 Scenario Definition
  // we'll do three different calls
  val scn = scenario(name = "Video Game DB - 3 calls")
    .exec(http(requestName = "1st call - Get all Video Games")
    .get("/videogame"))
  // add pause time of 5 seconds
    .pause(duration = 5)

    .exec(http(requestName = "2nd call - Get Specific Game")
      .get("/videogame/1"))
    // add pause time, this is random between 1-10 seconds
    .pause(1,10)

    .exec(http(requestName = "3rd call - Get all Video Games")
      .get("/videogame"))
    // add pause time 3000 milliseconds
    .pause(3000, milliseconds)

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
