package org.ssa.ironyard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SudokuGames {

    Map<String, SudokuGame> games = new HashMap<>();

    public void addGame(String difficulty, String id, String initial) {
	SudokuGame newGame = new SudokuGame();
	newGame.setId(id);
	newGame.setInitial(initial);
	newGame.setSolution(BTSudokuSolver.solve(initial));
	newGame.setDifficulty(difficulty);

	games.put(id, newGame);
    }

    public SudokuGame getGame(String difficulty) {
	Random r = new Random();
	SudokuGame gameToReturn = null;
	List<String> gameIDs = new ArrayList<String>(games.keySet());
	
	while(gameToReturn == null){
	    gameToReturn = games.get(gameIDs.get(r.nextInt(gameIDs.size())));
	    if(!gameToReturn.getDifficulty().equals(difficulty))
		gameToReturn = null;
	}
	
	return gameToReturn;
    }

    public SudokuGame getGame(String id, String solution) {
	return games.get(id);
    }
}
