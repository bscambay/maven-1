package org.ssa.ironyard.web;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssa.ironyard.Animal;
import org.ssa.ironyard.AnimalLink;
import org.ssa.ironyard.SSAZoo;

@RestController
@RequestMapping("/zoo")
public class ZooRestController {

    @Autowired
    SSAZoo zoo;
    
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
	response.setHeader("X-Powered-By", "SSA Zoo");
    }

    @RequestMapping(path = "/animals", method = RequestMethod.GET)
    public ResponseEntity<List<AnimalLink>> getAnimal(HttpServletRequest request){
	List<AnimalLink> animalLinks = new LinkedList<>();
	zoo.getAnimals().stream()
		.forEach(a -> animalLinks.add(
			new AnimalLink(a.getName(), request.getRequestURL() + a.getName())
			));
	return new ResponseEntity<List<AnimalLink>>(animalLinks, HttpStatus.OK);
    }

    @RequestMapping(path = "/animals/{animalName}", method = RequestMethod.GET)
    public ResponseEntity<Animal> getAnimal(@PathVariable String animalName, HttpServletRequest request) {
	return new ResponseEntity<Animal>(zoo.getAnimalByName(animalName), HttpStatus.OK);
    }
}
