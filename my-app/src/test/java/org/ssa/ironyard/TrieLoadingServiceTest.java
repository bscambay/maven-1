package org.ssa.ironyard;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class TrieLoadingServiceTest {

    T9Dictionary t9Trie = new T9Dictionary();
    TrieLoadingService tls;

    @Before
    public void initTrieLoadingService() throws URISyntaxException {
	tls = new TrieLoadingService(t9Trie);
    }

    @Test
    public void testT9TrieIsLoaded() throws URISyntaxException {
	assertTrue(t9Trie.suggest("").isEmpty());
	assertTrue(t9Trie.suggest("5").size() > 0);
    }
    
    @Test(expected=NullPointerException.class)
    public void testTrieLoadingServiceNull() throws URISyntaxException{
	new TrieLoadingService(null);
    }

}
