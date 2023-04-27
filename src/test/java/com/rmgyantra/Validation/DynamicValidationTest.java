package com.rmgyantra.Validation;

import static io.restassured.RestAssured.when;

import java.util.List;


import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicValidationTest {
@Test


	public void validationTest()
	{
		String expData="firr_11";
		Response rsps = when()
		.get("http://localhost:8084/projects");
		List<String> actData=rsps.jsonPath().get("projectName");
	//	for(int i=0;i<actData.size();i++)
	//	{
	//		String actualData=actData.get(i);
	//		if(expData.equals(actualData))
	//		{
	//			System.out.println(expData+" is available");
	//			break;
	//		}
	//	}
		
		for(String data:actData)
		{
		if(expData.equals(data))
		{
		System.out.println(expData+" is available");
	    break;
	   }
		}
		}
		
		
	}

