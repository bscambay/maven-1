package org.ssa.ironyard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class SSAZoo {
    private final List<Animal> animals = new LinkedList<>();
    
    public void addAnimal(Animal animal){
	animals.add(animal);
    }
    
    public List<Animal> getAnimals(){
	List<Animal> animals = new ArrayList<>(this.animals);
	return animals;
    }
    
    public Animal getAnimalByName(String animalName){
	List<Animal> animals = this.animals.stream()
		.filter(a -> a.getName().equalsIgnoreCase(animalName))
		.sorted((a,b) -> a.getName().compareToIgnoreCase(b.getName()))
		.limit(1)
		.collect(Collectors.toList());
	return animals == null ? null : animals.get(0);
    }
    
}
