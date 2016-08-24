package org.ssa.ironyard;

import java.net.URISyntaxException;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.ssa.ironyard.web.T9SuggestController;

public class T9SuggestControllerTest {
    
    T9SuggestController t9controller = new T9SuggestController();

    @Test(expected=IllegalArgumentException.class)
    public void testRequestWithBlankDigits() throws URISyntaxException {
	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/t9suggest");
	request.setParameter("digits", "");
	this.t9controller.getT9Suggestions(request);
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testRequestWithNoDigits() throws URISyntaxException {
	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/t9suggest");
	this.t9controller.getT9Suggestions(request);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testRequestWithAlphaDigits() throws URISyntaxException {
	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/t9suggest");
	request.setParameter("digits", "abcd");
	this.t9controller.getT9Suggestions(request);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testRequestWithInvalidNumDigits() throws URISyntaxException {
	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/t9suggest");
	request.setParameter("digits", "5431");
	this.t9controller.getT9Suggestions(request);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testRequestWithMixedDigits() throws URISyntaxException {
	MockHttpServletRequest request = new MockHttpServletRequest("GET", "/t9suggest");
	request.setParameter("digits", "5a");
	this.t9controller.getT9Suggestions(request);
    }

    
}
