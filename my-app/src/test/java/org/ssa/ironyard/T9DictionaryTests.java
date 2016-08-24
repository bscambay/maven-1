package org.ssa.ironyard;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ssa.ironyard.T9Dictionary;

public class T9DictionaryTests {

    T9Dictionary loadedDict, emptyDict;
    String apple = "27753";
    String faith = "32484";
    String conviction = "2668428466";
    String time = "8463";
    
    @Before
    public void initNewDictionary(){
	emptyDict = new T9Dictionary();
	loadedDict = new T9Dictionary();
	loadDictionaryFromFile(loadedDict);
    }
    
    private static void loadDictionaryFromFile(T9Dictionary dictionary) {

	try (BufferedReader reader = Files.newBufferedReader(
		Paths.get("C:/WS/repos/maven/my-app/src/main/resources/corncob_lowercase.txt"),
		Charset.defaultCharset())){
	    String line;
	    while (null != (line = reader.readLine())) {
		dictionary.addWord(line.trim());
	    }
	} 
	catch (IOException iex) {
	    System.err.println(iex);
	} 
    }

    @Test
    public void testT9WordIsEqualToT9OfWord() {
	assertTrue(T9Dictionary.convertWordToT9("apple").toString(), T9Dictionary.convertWordToT9("apple").get(0) == 2);
	assertTrue(T9Dictionary.convertWordToT9("apple").toString(), T9Dictionary.convertWordToT9("apple").get(1) == 7);
	assertTrue(T9Dictionary.convertWordToT9("apple").toString(), T9Dictionary.convertWordToT9("apple").get(2) == 7);
	assertTrue(T9Dictionary.convertWordToT9("apple").toString(), T9Dictionary.convertWordToT9("apple").get(3) == 5);
	assertTrue(T9Dictionary.convertWordToT9("apple").toString(), T9Dictionary.convertWordToT9("apple").get(4) == 3);
    }

    @Test
    public void testAddWordAddsWord() {
	assertFalse(emptyDict.contains("apple"));
	emptyDict.addWord("apple");
	assertTrue(emptyDict.contains("apple"));
    }

    @Test
    public void testRemoveWordRemovesWord() {
	emptyDict.addWord("apple");
	assertTrue(emptyDict.contains("apple"));
	emptyDict.remove("apple");
	assertFalse(emptyDict.contains("apple"));
    }

    @Test
    public void testOfFaith() {
	List<String> faith = loadedDict.suggest(this.faith);
	assertTrue(faith.contains("faith"));
	assertTrue(faith.contains("faithful"));
	assertTrue(faith.contains("faithfully"));
	assertTrue(faith.contains("faithfulness"));
	assertTrue(faith.contains("faithless"));
	assertTrue(faith.contains("faithlessness"));
	assertTrue(faith.contains("faiths"));
    }

    @Test
    public void testOfConviction() {
	List<String> conviction = loadedDict.suggest(this.conviction);
	assertTrue(conviction.contains("conviction"));
	assertTrue(conviction.contains("convictions"));
    }

    @Test
    public void testOfTime() {
	List<String> time = loadedDict.suggest(this.time);
	assertTrue(time.contains("time"));
	assertTrue(time.contains("tinderbox"));
	assertTrue(time.contains("vinegar"));
	assertFalse(time.contains("thyme"));
    }

    @Test
    public void testClearClears() {
	loadedDict.clear();
	assertTrue(loadedDict.suggest("2").size() == 0);
	assertTrue(loadedDict.suggest("3").size() == 0);
	assertTrue(loadedDict.suggest("4").size() == 0);
	assertTrue(loadedDict.suggest("5").size() == 0);
	assertTrue(loadedDict.suggest("6").size() == 0);
	assertTrue(loadedDict.suggest("7").size() == 0);
	assertTrue(loadedDict.suggest("8").size() == 0);
	assertTrue(loadedDict.suggest("9").size() == 0);
    }

    @Test
    public void testBadSuggestions() {
	assertTrue(loadedDict.suggest("").isEmpty());
	assertTrue(loadedDict.suggest("01lkhg").isEmpty());
	assertTrue(loadedDict.suggest("8890").isEmpty());
    }

    @Test
    public void testBadTriePath() {
	List<String> words555 = loadedDict.suggest("555");
	assertTrue(String.join("\n", words555), words555.isEmpty());
    }

    @Test
    public void testRemoveWordThatDoesntExist() {
	assertFalse(loadedDict.remove("fffffffff"));
    }
    
    @After
    public void clearLoadedDict(){
	loadedDict.clear();
    }
    
}