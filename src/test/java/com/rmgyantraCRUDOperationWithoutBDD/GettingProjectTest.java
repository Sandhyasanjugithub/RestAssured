package com.rmgyantraCRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingProjectTest {
@Test
public void getProject()
{
	Response rsps = RestAssured.get("http://localhost:8085/projects");
	//System.out.println(rsps.asString());
	//rsps.prettyPrint();
	ValidatableResponse vres = rsps.then();
	vres.assertThat().statusCode(200);
	vres.assertThat().contentType(ContentType.JSON);
	vres.log().all();
}
}
