package com.ApiEndPoints;

//import apiPayLoads.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import com.ApiPayloads.user;

import io.restassured.http.ContentType;

public class userEndPoints {
	
	public static Response createUser(user payload) {
		Response response =  
				given()
		/*
		 *  -H 'accept: application/json' \
  			-H 'Content-Type: application/json' \
		 */
		
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.postCall);
		return response;
		
	}
	
	public static Response getUser(String userName) {
		Response response =  
				given()
		/*
		 *  -H 'accept: application/json' \
  			-H 'Content-Type: application/json' \
		 */
		
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
//		.body(userName) // for get we donot need body
		.pathParam("username", userName)
		.when()
		.post(Routes.getCall);
		return response;
		
	}
	
	public static Response updateUser(String userName, user payload) {
		Response response =  
				given()
		/*
		 *  -H 'accept: application/json' \
  			-H 'Content-Type: application/json' \
		 */
		
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.post(Routes.putCall);
		return response;
		
	}
	
	public static Response deleteUser(String userName) {
		Response response =  
				given()
		/*
		 *  -H 'accept: application/json' \
		 */
		
		.accept(ContentType.JSON)
		.pathParam("username", userName)
//		.contentType(ContentType.JSON)// we donot need the contentType as website doesnot have this
//		.body(payload) // body not needed
		.when()
		.post(Routes.deleteCall);
		return response;
		
	}

}
