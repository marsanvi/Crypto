package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

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
	public void testServiceEncode() {
		assertEquals(TEST_RESULT, caesarService.encode(defaultAlphabet, TEST_STRING, 1));
	}

	@Test
	public void testServiceDecode() {
		assertEquals(TEST_STRING, caesarService.decode(defaultAlphabet, TEST_RESULT, 1));
	}

	@Test
	public void testCaesarControlerEncode() {
		when(caesarController.encode(defaultAlphabet, TEST_STRING, 1)).
		thenReturn(TEST_RESULT);
	}
	
	@Test
	public void testCaesarControlerDecode() {
		when(caesarController.decode(defaultAlphabet, TEST_RESULT, 1)).
		thenReturn(TEST_STRING);
	}

}
