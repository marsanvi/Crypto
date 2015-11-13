package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.marsanvi.crypto.exceptions.InvalidCipherException;
import com.marsanvi.crypto.services.SubstitutionService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SubstitutionServiceTest {
	
	private final static String defaultAlphabet =       "abcdefghijklmnopqrstuvwxyz";
	private final static String defaultAlphabetCipher = "cipherstuvwxyzabdfgjklmnoq";
	private final static String spanishtAlphabetCipher = "cipherstuvwxyzabñdfgjklmnoq";
	
	@Autowired
	SubstitutionService subtitutionService;

	@Configuration
	static class ConfigurationTest {
		@Bean
		public SubstitutionService subtitutionService() {
			return new SubstitutionService();
		}
	}
	
	@Test
	public void simpleEncode() throws InvalidCipherException{ 
		String text = "hello";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("texxa", encoded);
	}
	
	@Test
	public void simpleDecode() throws InvalidCipherException{ 
		String text = "texxa";
		String encoded = subtitutionService.decode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("hello", encoded);
	}
	
	@Test
	public void encodeVoid() throws InvalidCipherException{ 
		String text = "";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("", encoded);
	}
	
	@Test
	public void decodeVoid() throws InvalidCipherException{ 
		String text = "";
		String encoded = subtitutionService.decode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("", encoded);
	}
	
	@Test
	public void encodeSameAlphabet() throws InvalidCipherException { 
		String text = "hello";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabet,text);
		assertEquals("hello", encoded);
	}
	
	@Test
	public void decodeSameAlphabet() throws InvalidCipherException{ 
		String text = "texxa";
		String encoded = subtitutionService.decode(defaultAlphabet,defaultAlphabet,text);
		assertEquals("texxa", encoded);
	}
	
	@Test
	public void encodeCaseSensitive()throws InvalidCipherException { 
		String text = "Hello";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("texxa", encoded);
	}
	
	@Test
	public void decodeCaseSensitive() throws InvalidCipherException{ 
		String text = "tExXa";
		String encoded = subtitutionService.decode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("hello", encoded);
	}
	
	@Test
	public void encodeWhiteSpaces() throws InvalidCipherException { 
		String text = "hello sam";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("texxa gcy", encoded);
	}
	
	@Test(expected = InvalidCipherException.class)
	public void endoceWithInvalidCipherLengh() throws InvalidCipherException{
		String text = "hello";
		subtitutionService.encode(defaultAlphabet,spanishtAlphabetCipher,text);
	}
	
	@Test(expected = InvalidCipherException.class)
	public void dedoceWithInvalidCipherLengh() throws InvalidCipherException{
		String text = "texxa";
		subtitutionService.decode(defaultAlphabet,spanishtAlphabetCipher,text);
	}
	
	@Test
	public void validRandomAlphabet(){
		String randomAlphabet = subtitutionService.generateRandomAlphabet(defaultAlphabet);
		char[] chars1 = defaultAlphabet.toCharArray();
		char[] chars2 = randomAlphabet.toCharArray();
		Arrays.sort(chars1);
		Arrays.sort(chars2);
		System.out.println(randomAlphabet);
		assertFalse(randomAlphabet.equals(defaultAlphabet));
		assertTrue(Arrays.equals(chars1, chars2));
	}
	
	
	
}
