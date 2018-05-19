package com.crossover.techtrial.model;

import org.junit.Test;
import pl.pojo.tester.api.assertion.Assertions;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.include;

public class ArticleTest {
	 private static final Class<Article> articleClass = Article.class;

	    @Test
	    public void testPojo() {
	        Assertions.assertPojoMethodsFor(articleClass).testing(Method.CONSTRUCTOR, Method.GETTER, Method.SETTER).areWellImplemented();
	        Assertions.assertPojoMethodsFor(articleClass, include("id", "email", "title")).testing(Method.HASH_CODE).areWellImplemented();
	        Assertions.assertPojoMethodsFor(articleClass, include("id", "email", "title")).testing(Method.EQUALS).areWellImplemented();
	    }

}
