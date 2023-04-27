package scenarios;


import org.testng.annotations.Test;

import com.rmjYantraGenericUtilities.BaseApiClass;

import com.rmjYantraGenericUtilities.EndPoints;
import com.rmjYantraGenericUtilities.JavaUtility;
import com.rmjYantraPOJOLibrary.POJO;

import static io.restassured.RestAssured.*;


import java.sql.ResultSet;
import java.sql.SQLException;



import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class E2EScenarioTest extends BaseApiClass {
	@Test
	public void endToEnd() throws SQLException
	{
		
	   //step 1:post a request
		POJO P=new POJO("sant","sant_1033"+JavaUtility.getRandomNumber(),"created",10);
		
		baseURI="http://localhost";
		port=8084;
		Response rsps=given()
				.contentType(ContentType.JSON)
				.body(P)
				.when()
				.post(EndPoints.addProject);

		         rsps.prettyPrint();
				 String projectid=rsps.jsonPath().get("projectId");
				 System.out.println(projectid);
				 
				 
		//Step 2:Update the project
		POJO P1=new POJO("sant","sant_1044","created",8);
        given()
         .contentType(ContentType.JSON)
         .body(P1)
         .pathParam("projectId", projectid)
         .when()
         .put(EndPoints.completeUpdate);
        
        
       //Step 3:Get the project
		Response got=given()
		.pathParam("projectId", projectid)
		.contentType(ContentType.JSON)
		.body(P1)
	    .when()
		.get(EndPoints.getSingleProject);
		String projectname=got.jsonPath().get("projectName");
		System.out.println(projectname);
		
		//Step 4:connecting to DB and Verify the data is available or not
		ResultSet result=dUtil.executingQuery("select * from project;");
        while(result.next())
        {
	    if(projectname.equals(result.getString(4)))
	    {
	    System.out.println(projectname+" is available");
	    break;
	    }
        }
	}
}


