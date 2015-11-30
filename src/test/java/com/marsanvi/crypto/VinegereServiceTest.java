package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.marsanvi.crypto.exceptions.InvalidCipherException;
import com.marsanvi.crypto.services.CommonService;
import com.marsanvi.crypto.services.VinegereService;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class VinegereServiceTest {
	
	private final static String defaultAlphabet = "abcdefghijklmnopqrstuvwxyz";
	private final static String defaultCipher = "lemon";
	private final static String spanishtAlphabetCipher = "cipherstuvwxyzabñdfgjklmnoq";
	
	@Autowired
	VinegereService vinegereService;


	@Configuration
	static class ConfigurationTest {
		@Bean
		public VinegereService vinegereService() {
			return new VinegereService();
		}
	}
	
	@Test
	public void simpleEncode() throws InvalidCipherException{ 
		String text = "attackatdawn";
		String encoded = vinegereService.encode(defaultAlphabet,defaultCipher,text);
		assertEquals("lxfopvefrnhr", encoded);
	}
	
	@Test
	public void simpleDecode() throws InvalidCipherException{ 
		String text = "lxfopvefrnhr";
		String encoded = vinegereService.decode(defaultAlphabet,defaultCipher,text);
		assertEquals("attackatdawn", encoded);
	}
//	
//	@Test
//	public void encodeVoid() throws InvalidCipherException{ 
//		String text = "";
//		String encoded = vinegereService.encode(defaultAlphabet,defaultCipher,text);
//		assertEquals("", encoded);
//	}
//	
//	@Test
//	public void decodeVoid() throws InvalidCipherException{ 
//		String text = "";
//		String encoded = vinegereService.decode(defaultAlphabet,defaultCipher,text);
//		assertEquals("", encoded);
//	}
//	
//	@Test
//	public void encodeSameAlphabet() throws InvalidCipherException { 
//		String text = "hello";
//		String encoded = vinegereService.encode(defaultAlphabet,defaultAlphabet,text);
//		assertEquals("hello", encoded);
//	}
//	
//	@Test
//	public void decodeSameAlphabet() throws InvalidCipherException{ 
//		String text = "texxa";
//		String encoded = vinegereService.decode(defaultAlphabet,defaultAlphabet,text);
//		assertEquals("texxa", encoded);
//	}
//	
//	@Test
//	public void encodeCaseSensitive()throws InvalidCipherException { 
//		String text = "Hello";
//		String encoded = vinegereService.encode(defaultAlphabet,defaultCipher,text);
//		assertEquals("texxa", encoded);
//	}
//	
//	@Test
//	public void decodeCaseSensitive() throws InvalidCipherException{ 
//		String text = "tExXa";
//		String encoded = vinegereService.decode(defaultAlphabet,defaultCipher,text);
//		assertEquals("hello", encoded);
//	}
//	
//	@Test
//	public void encodeWhiteSpaces() throws InvalidCipherException { 
//		String text = "hello sam";
//		String encoded = vinegereService.encode(defaultAlphabet,defaultCipher,text);
//		assertEquals("texxa gcy", encoded);
//	}
//	
//	@Test(expected = InvalidCipherException.class)
//	public void endoceWithInvalidCipherLengh() throws InvalidCipherException{
//		String text = "hello";
//		vinegereService.encode(defaultAlphabet,spanishtAlphabetCipher,text);
//	}
//	
//	@Test(expected = InvalidCipherException.class)
//	public void dedoceWithInvalidCipherLengh() throws InvalidCipherException{
//		String text = "texxa";
//		vinegereService.decode(defaultAlphabet,spanishtAlphabetCipher,text);
//	}
//	
}
