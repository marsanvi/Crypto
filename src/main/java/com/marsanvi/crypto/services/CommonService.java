package com.marsanvi.crypto.services;

import java.util.HashSet;
import java.util.Set;


public class CommonService {

	public static boolean hasDuplicates(char[] inputChar){
		Set<Character> uniqueChars = new HashSet<Character> (inputChar.length, 1);
		for (int i=0; inputChar.length<i;i++) {
			if (!uniqueChars.add(inputChar[i])) return true;
		}
		return false;
	}
}
