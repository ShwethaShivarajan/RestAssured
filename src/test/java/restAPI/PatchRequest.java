package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchRequest {

	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000";
		RequestSpecification request = RestAssured.given();

		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("name", "Sia");

		Response response = request
				            .contentType(ContentType.JSON)
				            .accept(ContentType.JSON)
				            .body(mapObj)
				            .patch("employees/8");

		System.out.println(response.getBody().asString());

		int responseCode = response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200);
	}

}
