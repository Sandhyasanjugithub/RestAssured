package com.rmgyantraRequestPostByPojo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.rmjYantraPOJOLibrary.POJO;

import io.restassured.http.ContentType;

public class PojoRequestByUsingDataProviderTest {
	
		@Test(dataProvider="provideData")
		public void pojoRequest(String createdBy, String projectName, String status, int teamSize)
		{
			POJO P=new POJO(createdBy,projectName,status,teamSize);
			


		given()
		.contentType(ContentType.JSON)
		.body(P)
		.when()
		.post("http://localhost:8084/addProject")
		.then()


		.log().all();
			

		}
		public Object[][] ProvideData()
		{
			Object[][] objArr=new Object[2][4];
			objArr[0][0]="firr";
			objArr[0][1]="firr_11_1234";
			objArr[0][2]="created";
			objArr[0][3]=8;
			
			objArr[1][0]="firr";
			objArr[1][1]="firr_11_12345";
			objArr[1][2]="created";
			objArr[1][3]=8;
			
			return objArr;
					
		}
		}


