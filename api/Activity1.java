package activities;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class Activity1 {
	
	final static String Base_URI="https://petstore.swagger.io/v2/pet";
	
  @Test(priority=1)
  public void postRequest() {
	  //create json request
	  String Reqbody ="{"
			  + "\"id\" : 550232,"
			  + "\"name\" :\"Ricky\","
			  + "\"status\" :\"alive\""
			  +"}";
	  Response response =
			  given().contentType(ContentType.JSON)
			  .body(Reqbody)
			  .when().post(Base_URI);
	  //Assertions
	  response.then().body("id",equalTo(550232));
	  response.then().body("name",equalTo("Ricky"));
	  response.then().body("status",equalTo("alive"));
	  
	 }
  @Test(priority=2)
  public void getRequest() {
	  Response response =
			  given().contentType(ContentType.JSON)
			  .when().pathParam("petId","550232").get(Base_URI +"/{petId}");
	  
	//Assertions
	  response.then().body("id",equalTo(550232));
	  response.then().body("name",equalTo("Ricky"));
	  response.then().body("status",equalTo("alive"));
	  
	String body = response.getBody().asPrettyString();
	System.out.println(body);
  }
	
	@Test(priority=3)
	public void deleteRequest() {
	    Response response = 
	    		given().contentType(ContentType.JSON) // Set headers
	    	    .when().pathParam("petId","550232").delete(Base_URI +"/{petId}");
        // Assertion
		
        response.then().body("code", equalTo(200));
	    response.then().body("message", equalTo("550232"));
	}
  


 

}
