package org.ssa.ironyard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TrieLoadingService {

    static final Logger LOGGER = LogManager.getLogger(TrieLoadingService.class);

    @Autowired
    public TrieLoadingService(FileFactory ff, T9Dictionary t9Dict) throws URISyntaxException {
	File file = ff.getInstance();

	LOGGER.debug("file {}, exists?{}", file, file.exists());
	try (BufferedReader reader = Files.newBufferedReader(file.toPath(), Charset.defaultCharset())) {
	    String line;
	    while (null != (line = reader.readLine())) {
		LOGGER.trace("Word added to trie: {}", line);
		t9Dict.addWord(line.trim());
	    }
	} catch (IOException iex) {
	    System.err.println(iex);
	}
    }

}
