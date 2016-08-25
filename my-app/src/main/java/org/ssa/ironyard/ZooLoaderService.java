package org.ssa.ironyard;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ZooLoaderService {

    @Autowired
    public ZooLoaderService(SSAZoo zoo){
	zoo.addAnimal(new Animal(
		"aardvark",
		Arrays.asList("Africa"),
		"The Egyptian god Set is said (by some) to have the head of an aardvark or to be part aardvark."
		));
	zoo.addAnimal(new Animal(
		"baboon",
		Arrays.asList("Africa", "Asia"),
		"In Egyptian mythology, Babi was the deification of the hamadryas baboon and was therefore a sacred animal. It was known as the attendant of Thoth, so is also called the sacred baboon."
		));
	zoo.addAnimal(new Animal(
		"chimpanzee",
		Arrays.asList("Africa"),
		"Chimps communicate in a manner that is similar to that of human nonverbal communication."
		));
	zoo.addAnimal(new Animal(
		"donkey",
		Arrays.asList("Africa", "Asia"),
		"A male donkey (jack) can be crossed with a female horse to produce a mule. A male horse can be crossed with a female donkey to produce a hinny."
		));
	zoo.addAnimal(new Animal(
		"elephant",
		Arrays.asList("Africa", "Asia"),
		"Like many mammals, elephants can contract and transmit diseases to humans, one of which is tuberculosis."
		));
	zoo.addAnimal(new Animal(
		"fish",
		Arrays.asList("Africa", "Asia", "Antarctica", "Australia", "Europe", "North America", "South America"),
		"Fish are friends."
		));
	zoo.addAnimal(new Animal(
		"gorilla",
		Arrays.asList("Africa"),
		"Gorillas live in groups called troops."
		));
	zoo.addAnimal(new Animal(
		"horse",
		Arrays.asList("Africa", "Asia", "Europe"),
		"Horse meat has been used as food for humans and carnivorous animals throughout the ages."
		));
	zoo.addAnimal(new Animal(
		"iguana",
		Arrays.asList("North America", "South America"),
		"The two species of lizard within the genus Iguana possess a dewlap, a row of spines running down their backs to their tails, and a tiny \"third eye\" on their heads."
		));
	zoo.addAnimal(new Animal(
		"jackal",
		Arrays.asList("Africa", "Asia", "Europe"),
		"Like foxes and coyotes, jackals are often depicted as clever sorcerers in the myths and legends of their regions."
		));
	zoo.addAnimal(new Animal(
		"kangaroo",
		Arrays.asList("Australia"),
		"Kangaroos have chambered stomachs similar to those of cattle and sheep."
		));
	zoo.addAnimal(new Animal(
		"loris",
		Arrays.asList("Asia"),
		"Lorises are nocturnal. "
		));
	zoo.addAnimal(new Animal(
		"manatee",
		Arrays.asList("Africa", "North America", "South America"),
		"Manatees have been seen as far north as Cape Cod."
		));
	zoo.addAnimal(new Animal(
		"nightingale",
		Arrays.asList("Africa", "Asia", "Europe"),
		"The common nightingale has also been used as a symbol of poets or their poetry."
		));
	zoo.addAnimal(new Animal(
		"orangutan",
		Arrays.asList("Asia"),
		"Orangutans are among the most intelligent primates; they use a variety of sophisticated tools and construct elaborate sleeping nests each night from branches and foliage."
		));
	zoo.addAnimal(new Animal(
		"piranha",
		Arrays.asList("South America"),
		"Relative to body mass, the black piranha (Serrasalmus rhombeus) produces one of the most forceful bites measured in vertebrates."
		));
	zoo.addAnimal(new Animal(
		"quail",
		Arrays.asList("Europe", "North America"),
		"The collective noun for a group of quail is a flock, covey or bevy."
		));
	zoo.addAnimal(new Animal(
		"rhinoceros",
		Arrays.asList("Africa", "Asia"),
		"Both African species and the Sumatran rhinoceros have two horns, while the Indian and Javan rhinoceros have a single horn."
		));
	zoo.addAnimal(new Animal(
		"squirrel",
		Arrays.asList("Africa", "Asia", "Europe", "North America", "South America"),
		"The earliest known squirrels date from the Eocene and are most closely related to the mountain beaver and to the dormouse among living rodent families."
		));
	zoo.addAnimal(new Animal(
		"tree frog",
		Arrays.asList("Africa", "Asia", "Australia", "Europe", "North America", "South America"),
		"Tree frogs are usually tiny, as their weight has to be carried by the branches and twigs in their habitats."
		));
	zoo.addAnimal(new Animal(
		"unicorn",
		Arrays.asList("Asia", "Europe"),
		"In the Middle Ages and Renaissance, it was commonly described as an extremely wild woodland creature, a symbol of purity and grace, which could only be captured by a virgin."
		));
	zoo.addAnimal(new Animal(
		"velociraptor",
		Arrays.asList("Asia"),
		"The fact that the ancestors of Velociraptor were feathered and possibly capable of flight had long suggested to paleontologists that Velociraptor bore feathers as well, since even flightless birds today retain most of their feathers."
		));
	zoo.addAnimal(new Animal(
		"whale",
		Arrays.asList("Africa", "Asia", "Antarctica", "Australia", "Europe", "North America", "South America"),
		"Whales have evolved from land-living mammals. As such they must breathe air regularly, though they can remain submerged for long periods."
		));
	zoo.addAnimal(new Animal(
		"x-ray tetra",
		Arrays.asList("South America"),
		"It feeds primarily on small insects and planktonic animals."
		));
	zoo.addAnimal(new Animal(
		"yak",
		Arrays.asList("Asia"),
		"Wild yaks are among the largest bovids and are second only to the gaur in shoulder height."
		));
	zoo.addAnimal(new Animal(
		"zebu",
		Arrays.asList("Asia"),
		"In 1999, researchers at Texas A&M University successfully cloned a zebu."
		));
    }
}
