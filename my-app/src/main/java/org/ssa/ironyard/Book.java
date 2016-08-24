package org.ssa.ironyard;

import java.time.LocalDate;

public class Book {

	private final String title;
	private final String author;

	private final LocalDate publicationDate;

	public Book(String title, String author, LocalDate publicationDate) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

}
