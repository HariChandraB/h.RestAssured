package TestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import javax.mail.internet.ContentType;

import io.restassured.RestAssured;

public class TestCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://maps.googleapis.com";

		given().param("location", "-33.8670522,151.1957362").param("radius", "500")
				.param("key", "AIzaSyC7acd-_ehwzV-VsFB7jvixF20oBUV4DG4").
		when().get("/maps/api/place/nearbysearch/json").
				
		then().assertThat().statusCode(200).and().
//		assertThat().contentType(ContentType.JSON).
				body("results[0].name", equalTo("Sydney")).and()
				.body("results[0].place_id", equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and()
				.header("Server", "scaffolding on HTTPServer2");

	}

}


