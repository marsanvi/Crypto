package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CaesarHttpTest {

	private CloseableHttpClient httpClient;
	private HttpGet request;
	private CloseableHttpResponse httpResponse;
	private String content;
	
	@Before
	public void setup() {
		httpClient = HttpClientBuilder.create().build();
	}
	
	@Test
	public void testHttpRequestEncode() throws IOException {

		request = new HttpGet(
				"http://localhost:8080/caesar/encode?alphabet=abcdefghijklmnopqrstuvwxyz&text=hola&swift=1");

		httpResponse = httpClient.execute(request);
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

		content = EntityUtils.toString(httpResponse.getEntity());
		assertEquals("ipmb", content);
	}

	@Test
	public void testHttpRequestDecode() throws IOException {

		request = new HttpGet(
				"http://localhost:8080/caesar/decode?alphabet=abcdefghijklmnopqrstuvwxyz&text=ipmb&swift=1");

		httpResponse = httpClient.execute(request);
		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

		content = EntityUtils.toString(httpResponse.getEntity());
		assertEquals("hola", content);
	}

}
