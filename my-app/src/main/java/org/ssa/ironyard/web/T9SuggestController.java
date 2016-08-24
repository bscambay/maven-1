package org.ssa.ironyard.web;

import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssa.ironyard.T9Dictionary;

@Controller
@ComponentScan("org.ssa.ironyard")
public class T9SuggestController {

    @Autowired
    T9Dictionary t9Dict;

    public void setT9Dict(T9Dictionary t9Dict) {
	this.t9Dict = t9Dict;
    }

    Logger LOGGER = LogManager.getLogger(T9SuggestController.class);

    @ResponseBody
    @RequestMapping("/t9suggest")
    public String getT9Suggestions(HttpServletRequest request) throws URISyntaxException {
	if(request.getParameter("digits")==null){
	    LOGGER.error("No digits parameter provided");
	    throw new UnsupportedOperationException("Missing digits parameter");
	}
	if (!request.getParameter("digits").matches("[2-9]+")) {
	    LOGGER.error("Invalid request: {}", request.getParameter("digits"));
	    throw new IllegalArgumentException("Invalid digits entered");
	}
	
	return "<ol><li/>" + String.join("<li/>", this.t9Dict.suggest(request.getParameter("digits"))) + "</ol>";
    }
}
