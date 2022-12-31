package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithMap {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = ("http://localhost:3000");
		RequestSpecification request = RestAssured.given();
		
		Map<String, Object> mapObj = new HashMap<String, Object>();
		mapObj.put("name", "Rishi");
		mapObj.put("salary", "15500");
		
		Response response = request
				            .contentType(ContentType.JSON)
				            .accept(ContentType.JSON)
				            .body(mapObj)
				            .post("employees/create");
		
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 201);
		
	}

}
