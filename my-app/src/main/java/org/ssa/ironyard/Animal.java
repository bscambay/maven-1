package org.ssa.ironyard;

import java.util.List;

public class Animal {
    private final String name;
    private final List<String> nativeContinents;
    private final String interestingFact;

    public Animal(String name, List<String> nativeContinents, String interestingFact) {
	this.name = name;
	this.nativeContinents = nativeContinents;
	this.interestingFact = interestingFact;
    }

    public String getName() {
	return name;
    }

    public List<String> getNativeContinents() {
	return nativeContinents;
    }

    public String getInterestingFact() {
	return interestingFact;
    }

}
