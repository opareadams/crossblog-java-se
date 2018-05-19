package com.crossover.techtrial.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import static java.lang.String.format;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.crossover.techtrial.model.Article;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ArticleControllerTest {
	
	private static final String ARTICLE_ENDPOINT = "/articles/";
	  private static final String ARTICLE_GET_ENDPOINT = "/articles/%s";
	  private static final String ID = "1";
	  Article articlePOJO = new Article();

  @Autowired
  private TestRestTemplate template;

  @Before
  public void setup() throws Exception {
	  	articlePOJO.setTitle("hello");
	    articlePOJO.setEmail("user1@gmail.com");
  }

  @Test
  public void testArticleShouldBeCreated() throws Exception {
    HttpEntity<Object> article = getHttpEntity(articlePOJO);
    ResponseEntity<Article> resultAsset = template.postForEntity(ARTICLE_ENDPOINT, article,
        Article.class);
    Assert.assertNotNull(resultAsset.getBody().getId());
  }

  
  
  private HttpEntity<Object> getHttpEntity(Object body) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return new HttpEntity<Object>(body, headers);
  }
  
  @Test
  public void testArticleShouldBeFetched() throws Exception {
    ResponseEntity<Article> resultArticle = template.getForEntity(format(ARTICLE_GET_ENDPOINT, ID), Article.class);
    assertThat(resultArticle.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(resultArticle.getBody().getEmail()).isNotNull();
    assertThat(resultArticle.getBody().getId()).isEqualTo(1L);
  }
}
