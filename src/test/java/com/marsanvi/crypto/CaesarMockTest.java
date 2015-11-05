package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class CaesarMockTest {

	private final static String TEST_STRING = "abcdef";
	private final static String TEST_RESULT = "bcdefg";
	private final static String defaultAlphabet = "abcdefghijklmnopqrstuvwxyz";

	@Mock
	CaesarController caesarController;

	@InjectMocks
	private CaesarService caesarService;

	@Test
	public void testWithTestString() {
		assertEquals(TEST_RESULT, caesarService.encode(defaultAlphabet, TEST_STRING, 1));
	}

	@Test
	public void testService() throws IOException {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		HttpGet request = new HttpGet(
				"http://localhost:8080/caesar/encode?defaultAlphabet=abcdefghijklmnopqrstuvwxyz&text=hola&swift=2");

		CloseableHttpResponse httpResponse = httpClient.execute(request);

		assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());

		assertEquals("jqnc", httpResponse.getEntity().getContent().toString());
	}

}
