package com.rmgyantraRequestPostByPojo;

import org.testng.annotations.Test;

import com.rmjYantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PojoRequestTest {
@Test
public void pojoRequest()
{
	POJO P=new POJO("firr", "firr_11", "created", 7);
	


given()
.contentType(ContentType.JSON)
.body(P)
.when()
.post("http://localhost:8084/addProject")
.then()
 

.log().all();
	

}
}
