package org.ssa.ironyard.web;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.Book;

@Controller
public class BookController {

	Logger LOGGER = LogManager.getLogger(BookController.class);
	
	@RequestMapping("/books")
	@ResponseBody
	public Set<Book> getCatalog(){
		Set<Book> books = new HashSet<>();
		books.add(new Book("The Pragmatic Programmer: From Journeyman to Master", "David Thomas", LocalDate.of(1999, 10, 30)));
		books.add(new Book("Effective Java (2nd Edition)", "Joshua Bloch", LocalDate.of(2008, 05, 28)));
		books.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "David Thomas", LocalDate.of(2008, 8, 11)));
		LOGGER.debug("Book-set built");
		return books;
	}
}
