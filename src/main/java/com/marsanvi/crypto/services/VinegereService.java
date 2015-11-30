package com.marsanvi.crypto.services;

import org.springframework.stereotype.Service;

import com.marsanvi.crypto.exceptions.InvalidCipherException;

@Service
public class VinegereService {

	public String encode(String alphabet, String cipher, String text) throws InvalidCipherException {
		return encodeDecode(alphabet, cipher, text, false);
	}

	public String decode(String alphabet, String cipher, String text) throws InvalidCipherException {
		return encodeDecode(alphabet, cipher, text, true);
	}

	private String encodeDecode(String alphabet, String cipher, String text, boolean decode) throws InvalidCipherException {

		if (CommonService.hasDuplicates(cipher.toCharArray()))
			throw new InvalidCipherException("Duplicate character in the cipher");
		
		int factorEncode = 1;
		
		if(decode)
			factorEncode = -1;

		StringBuilder encodedSb = new StringBuilder();
		text = text.toLowerCase();
		int cipherLenght = cipher.length();
		int alphabetLenght = alphabet.length();
		char charText;
		for (int i = 0; i < text.length(); i++) {
			charText = text.charAt(i);
			if (Character.isLetter(charText)) {
				int valueCharText = alphabet.indexOf(charText);
				int valueCharCipher = alphabet.indexOf(cipher.charAt(i % cipherLenght));
				encodedSb.append(
						alphabet.charAt((alphabetLenght + valueCharText + valueCharCipher * factorEncode) % alphabetLenght));
			} else {
				encodedSb.append(charText);
			}
		}
		return encodedSb.toString();
	}

}
