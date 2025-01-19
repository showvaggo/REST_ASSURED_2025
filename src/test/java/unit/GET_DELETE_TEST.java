package unit;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class GET_DELETE_TEST {

	String baseUrl = "https://api.escuelajs.co/";
	// String baseUrl = "https://reqres.in/";
	String getAllProductsEndpoint = "api/users";

	@Test
	@Disabled
	public void getTestWithResponse() {
		Response response = RestAssured.given().get("https://api.escuelajs.co/api/v1/products");
		response.prettyPrint();
		System.out.println(String.format("Status Code : [%s] - %s", response.getStatusCode(), "Success"));
	}

	@Test
	@Disabled
	public void getTestInOneGo() {
		// List<Integer> statusCodes = List.of(200, 201, 204);

		RestAssured.given().baseUri(baseUrl) // Pre-Condition
				.basePath(getAllProductsEndpoint)
				.when()
				.log().all() // Request log
				.delete() // Action
				.then()
				.log().all() // Response log
				.statusCode(201)
				.body("data.id[0]", Matchers.equalTo(5)); // Validation
		
	}

	@Test
	// @Disabled
	public void singleGetTest() {
		

		Header header = new Header("X-SUB", "ehp");
		String baseUrlString = "https://api.escuelajs.co/";
		String endpoint = "api/v1/products/{id}";

		int productId = 129;

		RestAssured.given().baseUri(baseUrlString)
		        .basePath(endpoint)
		        .pathParam("id", productId)
				.queryParam("catagory", "shirts")
				.header(header)
				.auth()
				.preemptive()
				.basic("username", "password")
				.when()
				.log().all()
				.get()
				.then()
				.log().all()
				.statusCode(200);

		
	}

	@Test
	@Disabled
	public void singleDeleteTest() {
		String baseUrlString = "https://api.escuelajs.co/";
		String endpoint = "api/v1/products/{id}";

		int productId = 8;

		RestAssured.given().baseUri(baseUrlString)
		        .basePath(endpoint)
		        .pathParam("id", productId)
		        .when()
		        .log().all()
				.delete()
				.then()
				.log().all()
				.statusCode(200);
	}

}
