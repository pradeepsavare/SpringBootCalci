package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

	@Autowired
	CalculatorService calculatorservice;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	//Process of calculation
	
	@PostMapping("/calculate")
	public String calculate(@RequestParam("n1") double n1,@RequestParam("n2") double n2,@RequestParam("operation") String operation,Model model) {
		double result;
		switch(operation) {
		case "add" -> result = calculatorservice.add(n1, n2);
		case "sub" -> result = calculatorservice.sub(n1, n2);
		case "mul" -> result = calculatorservice.mul(n1, n2);
		case "div" -> result = calculatorservice.div(n1, n2);
		default->{
			model.addAttribute("error", "Invalid Operation");
			return "result";
		}
		}
		model.addAttribute("result", result);
		model.addAttribute("operation", operation);
		return "result";
		}
	}

