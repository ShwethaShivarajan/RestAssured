package restAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestwithFile {

	@Test
	public void test1() throws IOException {
		
		RestAssured.baseURI = ("http://localhost:3000");
		RequestSpecification request = RestAssured.given();
		
		 File datafile = new File("data.json");  // this can also be used instead of converting it to byte
	//	byte[] datafile = Files.readAllBytes(Paths.get("data.json"));
		
		Response response = request
				            .contentType(ContentType.JSON)
				            .accept(ContentType.JSON)
				            .body(datafile)
				            .post("employees/create");
		
		System.out.println(response.getBody().asString());
		
		int responseCode = response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 201);
		
	}

}

	

