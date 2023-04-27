package com.rmgyantraCRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeletingProjectTest {
	
		@Test
		public void deleteProject()
		{
			Response rsps = RestAssured.delete("http://localhost:8085/projects/TY_PROJ_202");
			//System.out.println(rsps.asString());
			//rsps.prettyPrint();
			ValidatableResponse vres = rsps.then();
			vres.assertThat().statusCode(204);
			vres.assertThat().contentType(ContentType.JSON);
			vres.log().all();
		}
		}


