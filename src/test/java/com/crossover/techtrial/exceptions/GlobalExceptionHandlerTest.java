package com.crossover.techtrial.exceptions;

import javassist.tools.web.BadHttpRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;

import java.util.AbstractMap;

import static org.junit.Assert.*;
public class GlobalExceptionHandlerTest {
	  private static final AbstractMap.SimpleEntry<String, String> response = new AbstractMap.SimpleEntry<String, String>(
	            "message", "Unable to process this request.");

	    @Test
	    public void handle() {
	        final GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
	        assertEquals(HttpStatus.BAD_REQUEST, globalExceptionHandler.handle(null).getStatusCode());
	        assertEquals(response, globalExceptionHandler.handle(null).getBody());
	    }

}
