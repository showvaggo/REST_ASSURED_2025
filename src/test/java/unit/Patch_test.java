package unit;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class Patch_test {
	@Test
	//@Disabled
public  void pach_test_go_on() {
	String baseUrl="https://reqres.in/";
	String basePath="api/users/{id}";
	String body="{\"name\" : \"Sapna\",\"job\" : \"QA engineer\"}";
	
	RestAssured.given()
	.baseUri(baseUrl)
	.basePath(basePath)
	.body(body)
	.pathParams("id" ,200)
	.contentType(ContentType.JSON)
	//.auth().preemptive()//if we have access
	.when()
	.log().all()
	.patch()
	.then()
	.log().all()
	.statusCode(200)
	.body("name", Matchers.equalTo("Sapna"));
	
	
}
}
