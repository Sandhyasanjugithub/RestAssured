package com.rmgyantra.Parameters;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PathParameterTest {
@Test
public void parameterPath()

{
	given()
	.pathParam("proid", "TY_PROJ_204")
	.when()
	.get("http://localhost:8084/projects/{proid}")
	.then()
	.log().all();
	
}
}
