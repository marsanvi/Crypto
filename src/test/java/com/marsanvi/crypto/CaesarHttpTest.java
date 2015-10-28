package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CaesarHttpTest {

	private final static String TEST_STRING = "abcdef";
	private final static String TEST_RESULT = "bcdefg";
	private final static String TEST_SWIFT = "1";

	@Test
	public void httpRequestEncode() throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/caesar/encode?text=" + TEST_STRING + "&swift=" + TEST_SWIFT;

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);

		System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

		assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		System.out.println(result.toString());
		assertEquals(TEST_RESULT, result.toString());

	}
	
	@Test
	public void httpRequestDecode() throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/caesar/decode?text=" + TEST_RESULT + "&swift=" + TEST_SWIFT;

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);

		HttpResponse response = client.execute(request);


		assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		assertEquals(TEST_STRING, result.toString());

	}

}
