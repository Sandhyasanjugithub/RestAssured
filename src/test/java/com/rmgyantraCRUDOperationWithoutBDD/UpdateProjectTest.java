package com.rmgyantraCRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {
	@Test
	public void updateProject()
	{
		
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "sam");
	jobj.put("projectName", "SDET_10_RestAssured");
			jobj.put("status", "created");
			jobj.put("teamSize", 8);
			
			RequestSpecification reqSpec = RestAssured.given();
			reqSpec.contentType(ContentType.JSON);
			reqSpec.body(jobj);
			
			 Response rsps = reqSpec.put("http://localhost:8085/projects/TY_PROJ_802");
			rsps.then().assertThat().statusCode(200).log().all();
			
			
	
}
}


