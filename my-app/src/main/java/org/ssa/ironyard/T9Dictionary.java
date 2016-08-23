package org.ssa.ironyard;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class T9Dictionary implements Text9Trie {

    static final Logger LOGGER = LogManager.getLogger(T9Dictionary.class);

    private static enum TraversalMode {
	READ, WRITE
    }

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
	TrieNode targetNode = traverse(T9Utils.convertWordToT9(word), TraversalMode.WRITE);
	LOGGER.trace("New word added to dictionary: {}", word);
	targetNode.words.add(word);
    }

    @Override
    public boolean contains(String word) {
	TrieNode targetNode = traverse(T9Utils.convertWordToT9(word), TraversalMode.READ);
	return targetNode == null ? false : targetNode.words.contains(word);
    }

    @Override
    public boolean remove(String word) {
	TrieNode targetNode = traverse(T9Utils.convertWordToT9(word), TraversalMode.READ);
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

	TrieNode current = traverse(T9Utils.convertWordToT9(digits), TraversalMode.READ);

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
