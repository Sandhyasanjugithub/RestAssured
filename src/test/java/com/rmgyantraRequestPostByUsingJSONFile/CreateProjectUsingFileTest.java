package com.rmgyantraRequestPostByUsingJSONFile;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingFileTest {
@Test
public void createProject()
{
	File f=new File("./Data1.json");
	
	given()
	.contentType(ContentType.JSON)
	.body(f)
	.when()
	.post("http://localhost:8085/addProject")
	.then()
	.assertThat().statusCode(201)
    .and().assertThat().contentType(ContentType.JSON)
    .log().all();
			
}
}

