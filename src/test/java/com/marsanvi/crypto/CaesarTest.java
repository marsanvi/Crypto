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
public class CaesarTest {
	
	@Autowired
	CaesarService caesarService;

	@Configuration
	static class ConfigurationTest {
		@Bean
		public CaesarService caesarService() {
			return new CaesarService();
		}
	}
	
	@Test
	public void simpleEncode() {
		String text = "hello";
		String encoded = caesarService.encode(text,1);
		assertEquals("ifmmp", encoded);
	}
	
	@Test
	public void bigOffsetEncode() {
		String text = "hello";
		String encoded = caesarService.encode(text,27);
		assertEquals("ifmmp", encoded);
	}
	
	@Test
	public void UpperCaseEncode() {
		String text = "HellO";
		String encoded = caesarService.encode(text,1);
		assertEquals("ifmmp", encoded);
	}
	
	@Test
	public void VoidEncode() {
		String text = "";
		String encoded = caesarService.encode(text,1);
		assertEquals("", encoded);
	}
	
	@Test
	public void NumberEncode() {
		String text = "12345";
		String encoded = caesarService.encode(text,1);
		assertEquals("12345", encoded);
	}
	//----------------------------------------------
	@Test
	public void simpleDecode() {
		String text = "ifmmp";
		String decoded = caesarService.decode(text,1);
		assertEquals("hello", decoded);
	}
	
	@Test
	public void bigOffsetDecode() {
		String text = "ifmmp";
		String decoded = caesarService.decode(text,27);
		assertEquals("hello", decoded);
	}
	
	@Test
	public void UpperCaseDecode() {
		String text = "IfmmP";
		String decoded = caesarService.decode(text,1);
		assertEquals("hello", decoded);
	}
	
	@Test
	public void VoidDecode() {
		String text = "";
		String decoded = caesarService.decode(text,1);
		assertEquals("", decoded);
	}
	
	@Test
	public void NumberDecode() {
		String text = "12345";
		String decoded = caesarService.decode(text,1);
		assertEquals("12345", decoded);
	}
}
