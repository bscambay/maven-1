package org.ssa.ironyard.web;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.Book;

@Controller
public class ServletRequestController {

    Logger LOGGER = LogManager.getLogger(ServletRequestController.class);

    @ResponseBody
    @RequestMapping("/request")
    public String getResponse(HttpServletRequest request) throws URISyntaxException {

	List<Book> books = new ArrayList<>();
	books.add(new Book("The Pragmatic Programmer: From Journeyman to Master", "David Thomas",
		LocalDate.of(1999, 10, 30)));
	books.add(new Book("Effective Java (2nd Edition)", "Joshua Bloch", LocalDate.of(2008, 05, 28)));
	books.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship", "David Thomas",
		LocalDate.of(2008, 8, 11)));
	URL resource = getClass().getClassLoader().getResource("some.txt");
	File file = new File(resource.toURI());
	LOGGER.debug("file {}, exists?{}", file, file.exists());

	return "You searched for " + request.getParameter("bookName");
    }
}
