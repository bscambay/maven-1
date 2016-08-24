package org.ssa.ironyard;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class TrieLoadingServiceTest {

    T9Dictionary t9Trie = new T9Dictionary();
    TrieLoadingService tls;
    FileFactory ff;

    @Before
    public void initTrieLoadingService() throws URISyntaxException {	
	ff = new WebFileFactory("corncob_lowercase.txt");
	tls = new TrieLoadingService(ff, t9Trie);
    }

    @Test
    public void testT9TrieIsLoaded() throws URISyntaxException {
	assertTrue(t9Trie.suggest("").isEmpty());
	assertTrue(t9Trie.suggest("2").size() > 0);
    }
    
    @Test(expected=NullPointerException.class)
    public void testTrieLoadingServiceNull() throws URISyntaxException{
	new TrieLoadingService(ff, null);
    }

}
