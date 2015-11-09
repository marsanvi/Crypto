package com.marsanvi.crypto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SubstitutionServiceTest {
	
	private final static String defaultAlphabet =       "abcdefghijklmnopqrstuvwxyz";
	private final static String defaultAlphabetCipher = "cipherstuvwxyzabdfgjklmnoq";
	
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
	public void simpleEncode() { 
		String text = "hello";
		String encoded = subtitutionService.encode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("texxa", encoded);
	}
	
	@Test
	public void simpleDecode() { 
		String text = "texxa";
		String encoded = subtitutionService.decode(defaultAlphabet,defaultAlphabetCipher,text);
		assertEquals("hello", encoded);
	}
	
}
