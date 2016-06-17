package de.yveskaufmann.restspawn.api;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class ApiException extends IOException {

	private StatusLine statusLine;
	private List<Header> headers;

	public ApiException(String message, HttpResponse httpResponse) {
		super(message);
		readResponse(httpResponse);
	}

	public ApiException(String message, Throwable cause, HttpResponse httpResponse) {
		super(message, cause);
		readResponse(httpResponse);
	}

	private void readResponse(HttpResponse httpResponse) {
		this.statusLine = httpResponse.getStatusLine();
		this.headers = Arrays.asList(httpResponse.getAllHeaders());
	}

	public int getStatusCode() {
		return statusLine.getStatusCode();
	}

	public List<Header> getHeaders() {
		return headers;
	}

}
