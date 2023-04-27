package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingWithParametersTest {
@Test
public void requestChaining()
{
	Response rsps=when()
			.get("http://localhost:8084/projects");
	rsps.prettyPrint();
	String projectid=rsps.jsonPath().get("[1].projectId");
	
	given()
	.pathParam("proId", projectid)
	.when()
	.delete("http://localhost:8084/projects/{proId}")
	.then()
	.log().all();
	
}
}
