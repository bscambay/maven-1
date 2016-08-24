package org.ssa.ironyard;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class T9Dictionary implements Text9Trie {

    static final Logger LOGGER = LogManager.getLogger(T9Dictionary.class);

    private static final Map<Character, Integer> aTo9Conversions = new HashMap<>(34);
    static {
	aTo9Conversions.put('a', 2);
	aTo9Conversions.put('b', 2);
	aTo9Conversions.put('c', 2);
	aTo9Conversions.put('d', 3);
	aTo9Conversions.put('e', 3);
	aTo9Conversions.put('f', 3);
	aTo9Conversions.put('g', 4);
	aTo9Conversions.put('h', 4);
	aTo9Conversions.put('i', 4);
	aTo9Conversions.put('j', 5);
	aTo9Conversions.put('k', 5);
	aTo9Conversions.put('l', 5);
	aTo9Conversions.put('m', 6);
	aTo9Conversions.put('n', 6);
	aTo9Conversions.put('o', 6);
	aTo9Conversions.put('p', 7);
	aTo9Conversions.put('q', 7);
	aTo9Conversions.put('r', 7);
	aTo9Conversions.put('s', 7);
	aTo9Conversions.put('t', 8);
	aTo9Conversions.put('u', 8);
	aTo9Conversions.put('v', 8);
	aTo9Conversions.put('w', 9);
	aTo9Conversions.put('x', 9);
	aTo9Conversions.put('y', 9);
	aTo9Conversions.put('z', 9);
	aTo9Conversions.put('2', 2);
	aTo9Conversions.put('3', 3);
	aTo9Conversions.put('4', 4);
	aTo9Conversions.put('5', 5);
	aTo9Conversions.put('6', 6);
	aTo9Conversions.put('7', 7);
	aTo9Conversions.put('8', 8);
	aTo9Conversions.put('9', 9);
    }

    public static List<Integer> convertWordToT9(String word) {
	List<Integer> wordAsIntList = new LinkedList<>();
	for (char c : word.toCharArray()) {
	    wordAsIntList.add(aTo9Conversions.get(c));
	}
	return wordAsIntList;
    }

    private static enum TraversalMode {
	READ, WRITE
    };

    private static EnumMap<TraversalMode, String> traversalModes = new EnumMap<>(TraversalMode.class);
    static {
	traversalModes.put(TraversalMode.READ, "Dictionary traversed in READ-ONLY mode");
	traversalModes.put(TraversalMode.WRITE, "Dictionary traversed in WRITE mode");
    }

    protected class TrieNode {
	TrieNode[] children = new TrieNode[10];
	Set<String> words = new HashSet<>();
    }

    private TrieNode root = new TrieNode();

    @Override
    public void addWord(String word) {
	TrieNode targetNode = traverse(convertWordToT9(word), TraversalMode.WRITE);
	LOGGER.trace("New word added to dictionary: {}", word);
	targetNode.words.add(word);
    }

    @Override
    public boolean contains(String word) {
	TrieNode targetNode = traverse(convertWordToT9(word), TraversalMode.READ);
	return targetNode == null ? false : targetNode.words.contains(word);
    }

    @Override
    public boolean remove(String word) {
	TrieNode targetNode = traverse(convertWordToT9(word), TraversalMode.READ);
	return targetNode == null ? false : targetNode.words.remove(word);
    }

    @Override
    public void clear() {
	root = new TrieNode();
    }

    @Override
    public List<String> suggest(String digits) {
	if (!digits.matches("[2-9]+"))
	    return Collections.<String>emptyList();

	TrieNode current = traverse(convertWordToT9(digits), TraversalMode.READ);

	if (current == null)
	    return Collections.<String>emptyList();

	List<String> suggestedWords = new LinkedList<>();

	suggestedWords.addAll(current.words);
	suggestedWords.addAll(getWordsOfTreeStartingAt(current));
	suggestedWords.sort(Comparator.naturalOrder());

	return suggestedWords;
    }

    private List<String> getWordsOfTreeStartingAt(TrieNode t) {
	List<String> suggestedWords = new LinkedList<>();
	for (TrieNode tNode : t.children) {
	    if (tNode == null)
		continue;

	    suggestedWords.addAll(getWordsOfTreeStartingAt(tNode));
	}
	suggestedWords.addAll(t.words);
	return suggestedWords;
    }

    private TrieNode traverse(List<Integer> digits, TraversalMode traversalMode) {
	LOGGER.trace("{}", traversalModes.get(traversalMode));
	TrieNode current = root;
	for (Integer i : digits) {
	    if (current.children[i] == null)
		switch (traversalMode) {
		case READ:
		    return null;
		case WRITE:
		    current.children[i] = new TrieNode();
		    break;
		}
	    current = current.children[i];
	}

	return current;
    }
}
