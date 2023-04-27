package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarrierTokenTest {
	@Test
	public void barrierToken()
	{
		
	
	given()
	.auth().oauth2("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")
	.when()
	.get("http://api.github.com/user/repos")
	.then()
	.log().all();
}
}
