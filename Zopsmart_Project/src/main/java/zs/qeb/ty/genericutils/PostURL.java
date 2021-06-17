package zs.qeb.ty.genericutils;

import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
/**
 * to get unique id from post request
 * @author rohit
 *
 */
public class PostURL implements BaseURI, EndPoints {
	/**
	 * Method will take the json file input and use the Json file
	 * for post request
	 * @return uniqueID
	 */
	public String postURLTestSuccess() {

		File file = new File(IConstants.JSONPathSuccess);

		RequestSpecification request = given().contentType(ContentType.JSON).body(file);

		Response response = request.when().post(URI + success + postProject);
		response.then().log().all();
		String uniqueID = response.jsonPath().getString("requestID");
		return "/"+uniqueID;
	}
}