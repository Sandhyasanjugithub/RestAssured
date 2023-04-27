package com.rmgyantraCRUDOperationWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectTest {
@Test
public void updateProject()
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
			.put("http://localhost:8085/projects/TY_PROJ_802")
			.then()
			.assertThat().statusCode(201)
		    .and().assertThat().contentType(ContentType.JSON)
		    .log().all();
					
}

}

