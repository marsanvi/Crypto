package com.marsanvi.crypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marsanvi.crypto.exceptions.InvalidCipherException;
import com.marsanvi.crypto.services.SubstitutionService;

@Controller
public class SubstitutionController {

	@Autowired
	SubstitutionService substitutionService;

	@RequestMapping("/substitution/encode")
	public @ResponseBody String encode(@RequestParam(value = "alphabet") String alphabet,
			@RequestParam(value = "cipher") String cipher, @RequestParam(value = "text") String text) {
		try {
			return substitutionService.encode(alphabet, cipher, text);
		} catch (InvalidCipherException e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping("/substitutionr/decode")
	public @ResponseBody String decode(@RequestParam(value = "alphabet") String alphabet,
			@RequestParam(value = "cipher") String cipher, @RequestParam(value = "text") String text) {
		try {
			return substitutionService.decode(alphabet, cipher, text);
		} catch (InvalidCipherException e) {
			e.printStackTrace();
			return "error";
		}
	}
}
