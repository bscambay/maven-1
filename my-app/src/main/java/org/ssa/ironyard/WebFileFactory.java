package org.ssa.ironyard;

import java.io.File;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebFileFactory implements FileFactory {

    private final String fileName;

    @Override
    public File getInstance() {
	try {
	    return new File(getClass().getClassLoader().getResource(fileName).toURI());
	} catch (URISyntaxException e) {
	    throw new RuntimeException("File not found");
	}
    }

    public WebFileFactory(@Value("corncob_lowercase.txt" )String fileName) {
	this.fileName = fileName;
    }

}
