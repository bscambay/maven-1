package org.ssa.ironyard;

import org.springframework.stereotype.Component;

@Component
public class SudokuGame {
    String id;
    String initial;
    String solution;
    String difficulty;

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getInitial() {
	return initial;
    }

    public void setInitial(String initial) {
	this.initial = initial;
    }

    public SudokuGame(){
	
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
