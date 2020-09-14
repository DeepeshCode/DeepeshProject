package framwork;

public class restClientResponse {
	
	private int code;
	private String Body;
	private String Headers;
	
	public restClientResponse(int code, String Body, String Headers)
	{
		this.setCode(code);
		this.setBody(Body);
		this.setHeaders(Headers);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getHeaders() {
		return Headers;
	}

	public void setHeaders(String headers) {
		Headers = headers;
	}

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}
	
	

}
