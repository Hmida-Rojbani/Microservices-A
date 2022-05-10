package de.tekup.contact.ctrls;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/contact")
public class ContactCtrl {
	
	private ServletWebServerApplicationContext applicationContext;
	
	@GetMapping("/check")
	public String check() {
		return "hello I am "+applicationContext.getId()
		+", on port :"+applicationContext.getWebServer().getPort();
	}

}
