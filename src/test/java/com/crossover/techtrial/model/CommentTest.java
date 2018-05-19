package com.crossover.techtrial.model;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import static org.junit.Assert.*;
import static pl.pojo.tester.api.FieldPredicate.include;

public class CommentTest {
	 private static final Class<Comment> commentClass = Comment.class;

	    @Test
	    public void testPojo() {
	        Assertions.assertPojoMethodsFor(commentClass).testing(Method.CONSTRUCTOR, Method.GETTER, Method.SETTER).areWellImplemented();
	        Assertions.assertPojoMethodsFor(commentClass, include("id", "email", "message")).testing(Method.HASH_CODE).areWellImplemented();
	        Assertions.assertPojoMethodsFor(commentClass, include("id", "email", "message")).testing(Method.EQUALS).areWellImplemented();
	    }
}
