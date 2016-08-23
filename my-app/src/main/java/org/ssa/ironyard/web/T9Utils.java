package org.ssa.ironyard.web;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

public class T9Utils {
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
}
