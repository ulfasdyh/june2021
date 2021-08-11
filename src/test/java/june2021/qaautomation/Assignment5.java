package june2021.qaautomation;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Assignment5 {

	@Test
	public void testRegistrationAPI() {
		Faker fake = new Faker();
		String email = fake.name().username() + "@gmail.com";
		System.out.println(email);

		String registrationPayLoad = "{\"user\":{\"first_name\":\"Name\",\"last_name\":\"\",\"email\":\"" + email
				+ "\",\"password\":\"builder123\",\"phone_number\":\"+62-8954684161\",\"user_type\":\"User\",\"currency_id\":3}}";

		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";

		Response response = RestAssured.given().contentType("application/json").body(registrationPayLoad).when()
				.post("users");

		assertEquals(response.getStatusCode(), 200);

	}

}
