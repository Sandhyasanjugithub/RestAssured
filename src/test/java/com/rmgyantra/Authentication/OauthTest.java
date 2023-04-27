package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class OauthTest {
@Test
public void oAuth()
{
	Response rsps = given()
	  .formParam("client_id", "SDET_101_RestAssured")
	  .formParam("client_secret", "afd6daf369d054006e170dee27b35416")
	  .formParam("grant_type", "client_credentials")
	  .formParam("redirect_uri", "https://example.com")
	  .when()
	  .post("http://coop.apps.symfonycasts.com/token");
	  String token=rsps.jsonPath().get("access_token");
	  System.out.println(token);
	  
	 given()
	 .auth().oauth2(token)
	 .pathParam("USER_ID","4069")
	 .when()
	  .post("http://coop.apps.symfonycasts.com/api/USER_ID/chickens-feed")
	  
	  .then()
	  .log().all();
	
	 
	 
}
}
