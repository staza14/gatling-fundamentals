package videogamedb.feeders
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import scala.util.Random

class ComplexCustomFeeder extends Simulation {

  // 1 Http Configuration
  val httpProtocol = http.baseUrl("https://videogamedb.uk/api")
    .acceptHeader("application/json")
    .contentTypeHeader(value = "application/json")


  val idNumbers = (1 to 10).iterator

  val rnd = new Random()

  val pattern = DateTimeFormatter.ofPattern("yyy-MM-dd")

  def randomString(length: Int) = {
    rnd.alphanumeric.filter(_.isLetter).take(length).mkString
  }

  def getRandomDate(startDate: LocalDate, random: Random): String ={
    startDate.minusDays(random.nextInt(30)).format(pattern)
  }

  val customFeeder = Iterator.continually(Map(
    "gameId" -> idNumbers.next(),
    "name" -> ("Game-" + randomString(5)),
    "releaseDate" -> getRandomDate(LocalDate.now, rnd),
    "reviewScore" -> rnd.nextInt(100),
    "category" -> ("Category-" + randomString(6)),
    "rating" -> ("Rating-" + randomString(4))
  ))

  def authenticate() = {
    exec(http("Authenticate")
      .post("/authenticate")
      .body(StringBody("{\n  \"password\": \"admin\",\n  \"username\": \"admin\"\n}"))
      .check(jsonPath("$.token").saveAs("jwtToken")))
  }

  def createNewGame() = {
    repeat(10) {
      feed(customFeeder)
        .exec(http("Create new game - #{name}")
        .post("/videogame")
        .header("authorization", "Bearer #{jwtToken}")
        .body(ElFileBody("bodies/newGameTemplate.json")).asJson
        .check(bodyString.saveAs("responseBody")))
        .exec { session => println(session("responseBody").as[String]); session}
        .pause(1)
    }
  }

  // 2 Scenario Definition
  val scn = scenario(name = "Complex Customer Feeder test")
    .exec(authenticate())
    .exec(createNewGame())

  // 3 Load Scenario
  setUp(
    scn.inject(atOnceUsers(users = 1))
  ).protocols(httpProtocol)
}
