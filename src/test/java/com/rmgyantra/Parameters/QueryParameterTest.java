package com.rmgyantra.Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class QueryParameterTest {
@Test
public void queryParameter()
{
	given()
	.pathParam("username","Sandhyasanjugithub")
	.queryParam("sort", "created")
	.when()
	.get("http://api.github.com/users/{username}/repos")
	.then()
	.log().all();
	
}
}
