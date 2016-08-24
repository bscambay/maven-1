package org.ssa.ironyard.web;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.Vegetable;
import org.ssa.ironyard.WeatherService;
import org.ssa.ironyard.Vegetable.Color;

@Controller
public class GreetingController {
	
	//IOC - Inversion of control
	//DI - Dependency injection
	Logger LOGGER = LogManager.getLogger(GreetingController.class);
	
	//DI
	@Autowired
	WeatherService weather;

	@RequestMapping("/temp")
	@ResponseBody
	public float currentTemp(){
		return this.weather.temperature();
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String greet() {
		return "Our first web app";
	}
	
	@RequestMapping("/foo")
	@ResponseBody
	public Map<String, LocalDate> now(){
		Map<String, LocalDate> model = new HashMap<>();
		model.put("now", LocalDate.now());
		return model;
	}
	
	@RequestMapping("/zucchini")
	@ResponseBody
	public Vegetable zucchini(){
		return new Vegetable(Color.GREEN, "zucchini");
	}
	
}
