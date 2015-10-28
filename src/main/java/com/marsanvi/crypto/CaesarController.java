package com.marsanvi.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CaesarController {

	@Autowired
	CaesarService caesarService;

	@RequestMapping("/caesar/encode")
	public @ResponseBody String encode(@RequestParam(value = "text") String text, @RequestParam(value = "swift") int swift) {
		return caesarService.encode(text, swift);
	}

	@RequestMapping("/caesar/decode")
	public @ResponseBody String decode(@RequestParam(value = "text") String text, @RequestParam(value = "swift") int swift) {
		return caesarService.decode(text, swift);
	}
}
