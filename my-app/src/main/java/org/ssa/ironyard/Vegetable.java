package org.ssa.ironyard;

public class Vegetable {

	public enum Color {
		RED, GREEN, YELLOW, ORANGE
	}

	private final Color color;
	private final String name;

	public Vegetable(Color color, String name) {
		this.color = color;
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

}
