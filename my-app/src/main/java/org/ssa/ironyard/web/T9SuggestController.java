package org.ssa.ironyard.web;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class T9SuggestController {

    @Autowired
    T9Dictionary t9Dict;

    Logger LOGGER = LogManager.getLogger(ServletRequestController.class);

    @ResponseBody
    @RequestMapping("/t9suggest")
    public String getT9Suggestions(HttpServletRequest request) throws URISyntaxException {

	return String.join("<br/>", t9Dict.suggest(request.getParameter("digits")));
    }
}
