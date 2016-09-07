package org.ssa.ironyard;

public class BTSudokuSolver {

    private static final char[] guesses = { '9','8','7','6','5','4','3','2','1' };

    public static String solve(String s) {
	if (gameSolved(s))
	    return s;

	for (char guess : guesses) {
	    StringBuilder b = new StringBuilder(s);
	    int location = nextBlank(b.toString());
	    if (guessValid(b.toString(),location, guess)) {
		b.setCharAt(location, guess);
		String solution = solve(b.toString());
		if (solution != null)
		    return solution;
	    }
	}
	return null;
    }

    protected static boolean guessValid(String game, int index, char guess) {
	return
		checkRow(game, index, guess) &&
		checkColumn(game, index, guess) &&
		checkBox(game, index, guess);
    }
    
    private static boolean checkBox(String game, int index, char guess){

	int baseRow = boxBase(index / 9);
	int baseColumn = boxBase(index % 9);

	for (int i = baseRow; i < baseRow + 3; i++)
	    for (int j = baseColumn; j < baseColumn + 3; j++)
		if (game.charAt(indexOf(i, j)) == guess)
		    return false;

	return true;
    }
    
    private static boolean checkRow(String game, int index, char guess){
	int row = index/9;
	for(int i = 0; i < 9; i++)
	    if(game.charAt(indexOf(row, i)) == guess)
		return false;
	return true;
    }
    
    private static boolean checkColumn(String game, int index, char guess){
	int column = index%9;
	for(int i = 0; i < 9; i++)
	    if(game.charAt(indexOf(i, column)) == guess)
		return false;
	return true;
    }

    private static int indexOf(int row, int column) {
	return row * 9 + column;
    }

    private static int boxBase(int rowOrColumn) {
	if (rowOrColumn < 3)
	    return 0;
	if (rowOrColumn < 6)
	    return 3;
	return 6;
    }
    
    public static String toString(String game) {
	return game.substring(0, 9) + "\n" + game.substring(9, 18) + "\n" + game.substring(18, 27) + "\n"
		+ game.substring(27, 36) + "\n" + game.substring(36, 45) + "\n" + game.substring(45, 54) + "\n"
		+ game.substring(54, 63) + "\n" + game.substring(63, 72) + "\n" + game.substring(72, 81);
    }

    private static boolean gameSolved(String game) {
	if (game.contains("0"))
	    return false;
	return true;
    }

    private static int nextBlank(String game) {
	return game.indexOf('0');
    }

}
