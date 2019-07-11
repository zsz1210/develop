package com.dsite.serverstatus;

import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
