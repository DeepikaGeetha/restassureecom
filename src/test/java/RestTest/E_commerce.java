package RestTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class E_commerce {
	public static String baseurl = "https://ecommerceservice.herokuapp.com";
	public static String message;
	public static String accessToken;
	public static String id;
	@Test(priority = 0)
	public void signup()
	{
		RestAssured.baseURI = baseurl;
		String 	requestbody = "{\n"
				+ "	\"email\": \"jeevan@gmail.com\",\n"
				+ "	\"password\": \"arti\"\n"
				+ "}";
		Response response = given()
				.header("Content-Type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/signup")
				
				.then()
				.assertThat().statusCode(400).contentType(ContentType.JSON)
				.extract().response();	
		String jsonresponse = response.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		//nw i have to fetch the id
		message = js.get("message");
		System.out.println(message);
		
		
	}
	@Test(priority = 1)
	public void login()
	{
		RestAssured.baseURI = baseurl;
		String 	requestbody = "{\n"
				+ "	\"email\": \"jeevan@gmail.com\",\n"
				+ "	\"password\": \"arti\"\n"
				+ "}";
		Response response = given()
				.header("Content-Type","application/json")
				.body(requestbody)
				
				.when()
				.post("/user/login")
				
				.then()
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				.extract().response();	
		String jsonresponse = response.asString();
		//i want to convert the response in to json format
		//why do i use jsonpath to convert the string in to a json format
		JsonPath js = new JsonPath(jsonresponse);
		
		//nw i have to fetch the id
		//message = js.get("message");
		//System.out.println(message);
		accessToken=js.get("accessToken");
		System.out.println(accessToken);
		
		}
	  
	
	@Test (priority=2)
	public void getusers()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().
		//queryParam("Authorization","bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjMxNmUyMGM0MDM0MjAwMTc3NDY0YzciLCJpYXQiOjE2NDc0MDY2MzQsImV4cCI6MTY0NzQ5MzAzNH0.6a-AE-Xo4ztOhBIHyDHRLYipnSM3qCENoGD0Q8vcVmc")
		 header("Content-Type","application/json")
		.header("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjMxNmUyMGM0MDM0MjAwMTc3NDY0YzciLCJpYXQiOjE2NDc0MDY2MzQsImV4cCI6MTY0NzQ5MzAzNH0.6a-AE-Xo4ztOhBIHyDHRLYipnSM3qCENoGD0Q8vcVmc ")
		.when()
		.get("/user")
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		JsonPath js = new JsonPath(jsonresponse);
		id=js.get("users[100]._id");
	}
	@Test (priority=3)
	public void deleteuser()
	{
		RestAssured.baseURI = baseurl;
		Response response = given().
		//queryParam("Authorization","bearer ")
		 header("Content-Type","application/json")
		.header("Authorization", "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjMxNmUyMGM0MDM0MjAwMTc3NDY0YzciLCJpYXQiOjE2NDc0MDY2MzQsImV4cCI6MTY0NzQ5MzAzNH0.6a-AE-Xo4ztOhBIHyDHRLYipnSM3qCENoGD0Q8vcVmc ")
		.when()
		.delete("/user/" + id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON)
		.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
	}
}