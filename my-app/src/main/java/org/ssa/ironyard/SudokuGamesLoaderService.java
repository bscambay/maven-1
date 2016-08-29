package org.ssa.ironyard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SudokuGamesLoaderService {

    static final Logger LOGGER = LogManager.getLogger(TrieLoadingService.class);

    @Autowired
    public SudokuGamesLoaderService(SudokuGames games) throws URISyntaxException {

	File file = new File(getClass().getClassLoader().getResource("sudoku puzzles.txt").toURI());

	LOGGER.debug("file {}, exists?{}", file, file.exists());
	try (BufferedReader reader = Files.newBufferedReader(file.toPath(), Charset.defaultCharset())) {
	    String line;
	    while (null != (line = reader.readLine())) {
		LOGGER.trace("Game line processed: {}", line);
		String game[] = line.split(",");
		games.addGame(game[1], game[0], game[2]);
		}

	    
	} catch (IOException iex) {
	    System.err.println(iex);
	}

    }
}
