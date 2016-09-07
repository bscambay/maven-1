package org.ssa.ironyard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NQSudokuSolver {

    List<Character> guesses = new ArrayList<>();

    Row[] rows = new Row[9];

    public NQSudokuSolver(String initial) {

	Map<Character, Integer> charCounts = new HashMap<>();

	for (int i = 0; i < rows.length; i++)
	    rows[i] = new Row();

	for (int i = 0; i < initial.length(); i++) {
	    char c = initial.charAt(i);
	    charCounts.put(c, charCounts.get(c) == null ? 1 : charCounts.get(c) + 1);
	    rows[i / 9].set(i % 9, c);
	}

	charCounts.remove('0');
	charCounts.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
		.forEachOrdered(e -> guesses.add(e.getKey()));
    }
    
    protected void solveByRow(int row, int guess){
	for(int i = 0; i < 9; i++){
	    char c = guesses.get(guess);
	    if(check(row, i, c)){
		rows[row].set(i, c);
		if(row == 8)
		    return;
		else solveByRow(row + 1, guess);
	    }
	    rows[row].set(i, '0');
	}
    }

    protected boolean check(int row, int col, char c) {
	if (rows[row].contains(c))
	    return false;
	for(int i = 0; i < row; i++)
	    if(rows[row].get(col) == c)
		return false;
	int top = (row/3)*3;
	int left = (col/3)*3;
	for(int i = top; i < row; i++)
	    for(int j = left; j < left + 3; j++)
		if(rows[i].get(j) == c)
		    return false;
	return true;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < rows.length; i++)
	    sb.append(rows[i].toString() + "\n");
	return sb.toString();
    }

}