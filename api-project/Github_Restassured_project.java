package restassuredproject;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Github_Restassured_project {
	//String Base_uri="https://api.github.com";
	RequestSpecification requestspec;
	String SSHKey="ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCi1jmnobljsJlm1XkDt5qv7FKVbd/WhsDhS80umlhqk4UlrrAjAbQbtq3IakujttDT9YK5NTxIrsVquswqv7BJpWFU03dkwn94NU/DBJ23AJzU6IzGwWuSwsDyP5TQu3W8BrakVcLGCs5sRKiXeAgHdgJ7hDWrotzfvl45lLA2u0AtlkC4JkYEzcwRAN3f7z42+tf2a8SgseGi/7AkCk70KrS9JCG3jvxoJ9iLkusjlnX83KvNyVMapT5JR2iiEyThJTNrPk3uxiNlVtKbcifL5vYSQcXE8MtNFMGAWt+gsVoSSLOq3u2c5TqL2v6qpTWSX1NxBY3dl+n+cUCjJbXV";
	int SSHid;
	
	@BeforeClass
    public void setUp()
	{
        // Create request specification
        requestspec = new RequestSpecBuilder()
                
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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")
                .setBaseUri("https://api.github.com")
                .build();
	}
	
	@Test(priority=1)
	public void postRequest() {
		String reqbody=
				"{\"title\" : \"TestKey\", \"key\": \"" +SSHKey + "\"}";
		 Response response =
				  given().spec(requestspec)
				  .body(reqbody)
				  .when().post("/user/keys");
		 
		 String resbody= response.getBody().asPrettyString();
		 System.out.println(resbody);
		 SSHid= response.then().extract().path("id");
		
		// Assertion
		 response.then().statusCode(201);
		 
		 
	}
	
	@Test(priority=2)
	public void getsshkey() {
		Response response =
				  given().spec(requestspec)//requestspec
				 .when().get("/user/keys");//get request 
		System.out.println(response.asPrettyString());
		response.then().statusCode(200);
		
	}
	
	@Test(priority=3)
	public void deletesshkey() {
		Response response =
				  given().spec(requestspec).pathParam("Keyid",SSHid)//requestspec
				 .when().delete("/user/keys/{Keyid}");//get request 
		//Assertion
		response.then().statusCode(204);
	}

}
