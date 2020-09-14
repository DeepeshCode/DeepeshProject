package framwork;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class restClientWrapper {

	public static RequestSpecification request;
	public static Response response;
	public static restClientResponse restResponse;
	
	
	public restClientResponse post(String url, String body) {
		request = RestAssured.given();
		request.body(body);
		request.relaxedHTTPSValidation();
		response = request.post(Constant.baseURL+url);
		restResponse = new restClientResponse(response.getStatusCode(), 
		response.getBody().asString(), response.getHeaders().toString());
		return restResponse;
	}
}
