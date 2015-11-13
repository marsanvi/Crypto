package com.marsanvi.crypto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marsanvi.crypto.services.CaesarService;

@Controller
public class CaesarController {

	@Autowired
	CaesarService caesarService;

	@RequestMapping("/caesar/encode")
	public @ResponseBody String encode(@RequestParam(value = "alphabet") String alphabet,@RequestParam(value = "text") String text, @RequestParam(value = "swift") int swift) {
		return caesarService.encode(alphabet,text, swift);
	}

	@RequestMapping("/caesar/decode")
	public @ResponseBody String decode(@RequestParam(value = "alphabet") String alphabet,@RequestParam(value = "text") String text, @RequestParam(value = "swift") int swift) {
		return caesarService.decode(alphabet,text, swift);
	}
}
