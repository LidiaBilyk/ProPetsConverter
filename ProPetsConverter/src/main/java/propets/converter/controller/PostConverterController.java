package propets.converter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import propets.converter.dto.PostDto;
import propets.converter.service.PostConverterService;

@RestController
@RequestMapping("/{lang}/v1")
public class PostConverterController {
	@Autowired
	PostConverterService postConverterService;
	
	@PostMapping("/searchdata")
	public void sendData(@RequestBody PostDto postDto) {
		 postConverterService.sendData(postDto);
	}

}
