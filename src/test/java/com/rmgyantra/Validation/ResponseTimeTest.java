package com.rmgyantra.Validation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class ResponseTimeTest {
@Test
public void responseTest()
{
	when()
	
	.get("http://localhost:8084/projects")
	.then()
    .assertThat().time(Matchers.lessThan(7000L),TimeUnit.MILLISECONDS)
    .assertThat().body("[1].projectName", Matchers.equalTo("firr_11"))

	.log().all();
}
}
