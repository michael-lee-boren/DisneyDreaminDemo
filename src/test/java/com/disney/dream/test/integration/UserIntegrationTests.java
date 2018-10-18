package com.disney.dream.test.integration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.disney.dream.ExampleApplication;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = ExampleApplication.class)
public class UserIntegrationTests {   
  private static final String FIRST_NAME_FIELD = "firstName";
  private static final String LAST_NAME_FIELD = "lastName";
  private static final String PASSWORD_FIELD = "password";
  private static final String ID_FIELD = "id";
  
  private static final String USERS_RESOURCE = "/user";
  private static final String USER_RESOURCE = "/user/{id}";
  
  private static final String FIRST_USER_FIRST_NAME = "Michael";
  private static final String SECOND_USER_FIRST_NAME = "Walt";
  private static final String THIRD_USER_FIRST_NAME = "Tinker";
  
  private static final String FIRST_USER_LAST_NAME = "Boren";
  private static final String SECOND_USER_LAST_NAME = "Disney";
  private static final String THIRD_USER_LAST_NAME = "Bell";
  
  private static final String FIRST_USER_PASSWORD = "Dream";
  private static final String SECOND_USER_PASSWORD = "Mickey";
  private static final String THIRD_USER_PASSWORD = "PixieDust";
  
  private static final Integer FIRST_USER_ID = 1;
  private static final Integer SECOND_USER_ID = 2;
  private static final Integer THIRD_USER_ID = 3;
  
  private static final Integer GET_USER_ID = 100;
  
  @LocalServerPort
  private int serverPort;
  
  @Before
  public void setUp() {
    RestAssured.port = serverPort;
  }
  
  @Test
  public void getListOfUsers() {
	  given()
	  	.contentType(ContentType.JSON)
	  .when()
	  	.get(USERS_RESOURCE)
	  .then()
	  	.statusCode(HttpStatus.SC_OK)
	  	.body(FIRST_NAME_FIELD, hasItems(FIRST_USER_FIRST_NAME, SECOND_USER_FIRST_NAME, THIRD_USER_FIRST_NAME))
	  .and()
	  	.body(LAST_NAME_FIELD, hasItems(FIRST_USER_LAST_NAME, SECOND_USER_LAST_NAME, THIRD_USER_LAST_NAME))
	  .and()
	  	.body(ID_FIELD, hasItems(FIRST_USER_ID, SECOND_USER_ID, THIRD_USER_ID))
	  .and()
	  	.body(PASSWORD_FIELD, hasItems(FIRST_USER_PASSWORD, SECOND_USER_PASSWORD, THIRD_USER_PASSWORD));
	  
  }
  
  @Test
  public void getSingleUser() {
	  given()
	  	.contentType(ContentType.JSON)
	  .when()
	  	.get(USER_RESOURCE, GET_USER_ID)
	  .then()
	  	.statusCode(HttpStatus.SC_OK)
	  	.body(ID_FIELD, equalTo(GET_USER_ID));
  }
  
}