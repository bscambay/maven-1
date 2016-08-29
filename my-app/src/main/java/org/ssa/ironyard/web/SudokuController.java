package org.ssa.ironyard.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.ssa.ironyard.SudokuGame;
import org.ssa.ironyard.SudokuGames;

@RestController
@RequestMapping("/sudoku")
public class SudokuController {

    @RequestMapping(value = "")
    public View home() {
	return new InternalResourceView("home-sudoku.html"); // BINGO - although
							     // could just use
							     // string probably
    }

    @Autowired
    SudokuGames games;

    @RequestMapping("/{gameDifficulty}")
    public Map<String, String> getAGame(@PathVariable String gameDifficulty) {
	Random r = new Random();
	Map<String, String> returnedGameMap = new HashMap<>();
	SudokuGame returnedGame = games.getGame(gameDifficulty);
	returnedGameMap.put("initial", returnedGame.getInitial());
	returnedGameMap.put("game", returnedGame.getId());
	return returnedGameMap;
    }

    @RequestMapping(value = "{gameID}", params = "solution")
    public Map<String, List<String>> getAGame(@PathVariable String gameID, @RequestParam("solution") String solution) {
	Map<String, List<String>> returnedGameMap = new HashMap<>();
	List<String> errors = new ArrayList<>();
	SudokuGame returnedGame = games.getGame(gameID, solution);
	for (int i = 0; i < returnedGame.getSolution().length(); i++) {
	    if (!(returnedGame.getSolution().charAt(i) == solution.charAt(i)))
		if (solution.charAt(i) != '0')
		    errors.add(Integer.toString(i));
	}

	returnedGameMap.put("errors", errors);
	returnedGameMap.put("game", Arrays.asList(returnedGame.getId()));
	return returnedGameMap;
    }

}
