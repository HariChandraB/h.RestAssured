package TestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;

public class TestCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BaseURL or Host
		RestAssured.baseURI = "https://maps.googleapis.com";

		given().
				param("location", "-33.8670522,151.1957362").
				param("radius", "500").
				param("key", "AIzaSyA0rJzucZtmYn9gaQzUg_-g0IoizQJfh2s").
				
		when().
				get("/maps/api/place/nearbysearch/json").
				
		then().
				assertThat().statusCode(404).and().
				// assertThat().contentType(ContentType.JSON).
				body("results[0].name", equalTo("Sydney")).and()
				.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and()
				.header("Server", "scaffolding on HTTPServer2");

	}

}
