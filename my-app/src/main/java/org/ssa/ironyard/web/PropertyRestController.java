package org.ssa.ironyard.web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.ssa.ironyard.Property;

@RestController
public class PropertyRestController {

    @ResponseBody
    @RequestMapping("/realestate/{city}/{street}")
    public List<Property> search(@PathVariable String city, @PathVariable String street) {
	
	
    }
}
