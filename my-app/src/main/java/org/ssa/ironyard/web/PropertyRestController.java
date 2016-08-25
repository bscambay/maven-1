package org.ssa.ironyard.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssa.ironyard.Property;

@RestController
public class PropertyRestController {

    @Component
    private class Properties {
	private List<Property> properties = new LinkedList<>();

	public void add(Property property) {
	    properties.add(property);
	}

	public List<Property> getList() {
	    return new LinkedList<Property>(properties);
	}
	
	public void clear(){
	    properties = new LinkedList<>();
	}
    }

    @Autowired
    Properties properties;

    @RequestMapping("/realestate/{city}/{street}")
    public List<Property> search(@PathVariable String city, @PathVariable String street) {
	
	properties.clear();
	Random r = new Random();
	for (int i = 0; i < r.nextInt(25) + 1; i++)
	    properties.add(new Property((r.nextInt(1000) + 1) * 1000, city, street, (r.nextInt(17) + 7) * 100));
	return properties.getList();
    }
}
