import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Direct {
	
	@Test
	public static void testrun() {
		
		given().
		when().
		get("https://24ksg1gjmb.execute-api.ap-south-1.amazonaws.com/qa/maruti/user/v1/maruti/7777881122").
		then().
		assertThat().
		body("message", equalTo("OTP fetched successfully"));
		
	}
}
