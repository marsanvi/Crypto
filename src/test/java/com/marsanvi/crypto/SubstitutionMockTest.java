package com.marsanvi.crypto;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marsanvi.crypto.controllers.SubstitutionController;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class SubstitutionMockTest {

	private final static String TEST_STRING = "hello";
	private final static String TEST_RESULT = "texxa";
	private final static String defaultAlphabet = "abcdefghijklmnopqrstuvwxyz";
	private final static String defaultAlphabetCipher = "cipherstuvwxyzabdfgjklmnoq";

	@Mock
	SubstitutionController substitutionController;


	@Test
	public void testCaesarControlerEncode() {
		when(substitutionController.encode(defaultAlphabet,defaultAlphabetCipher, TEST_STRING)).
		thenReturn(TEST_RESULT);
	}
	
	@Test
	public void testCaesarControlerDecode() {
		when(substitutionController.decode(defaultAlphabet,defaultAlphabetCipher, TEST_RESULT)).
		thenReturn(TEST_STRING);
	}
	
	

}
