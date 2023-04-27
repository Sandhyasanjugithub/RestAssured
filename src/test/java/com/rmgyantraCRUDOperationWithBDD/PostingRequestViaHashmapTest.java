package com.rmgyantraCRUDOperationWithBDD;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostingRequestViaHashmapTest {
@Test
public void postingrequest()
{
	HashMap hp=new HashMap();
	hp.put("createdBy", "sam");
	hp.put("projectName", "SDET_10_Rest");
			hp.put("status", "created");
			hp.put("teamSize", 10);
			
			RequestSpecification reqSpec = RestAssured.given();
			reqSpec.contentType(ContentType.JSON);
			reqSpec.body(hp);
			
			 Response rsps = reqSpec.post("http://localhost:8085/addProject");
			rsps.then().assertThat().statusCode(201).log().all();
			
			
}
}
