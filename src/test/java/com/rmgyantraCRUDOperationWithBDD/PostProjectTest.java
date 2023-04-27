package com.rmgyantraCRUDOperationWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class PostProjectTest {
	@Test
	public void createProject()
	{
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "sam");
		jobj.put("projectName", "SDET_10_RestAssured_122");
				jobj.put("status", "created");
				jobj.put("teamSize", 10);
				
				given()
				.contentType(ContentType.JSON)
				.body(jobj)
				.when()
				.post("http://localhost:8085/addProject")
				.then()
				.assertThat().statusCode(201)
			    .and().assertThat().contentType(ContentType.JSON)
			    .log().all();
						
}
}
