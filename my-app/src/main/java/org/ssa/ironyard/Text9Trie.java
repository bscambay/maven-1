package org.ssa.ironyard;

import java.util.List;

import org.springframework.stereotype.Component;

public interface Text9Trie {
    /**
     * adds a word to this tries "dictionary"
     */
    void addWord(String word);

    boolean contains(String word);

    boolean remove(String word);

    void clear();

    /**
     * @ return a 'logical' set of words in ascending lexical order
     */
    List<String> suggest(String digits);

}
