package com.ApiTestCases;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ApiEndPoints.userEndPoints;
import com.ApiPayloads.user;

public class UserTest {
	
	Faker faker;
	user userPayload;
	
	@BeforeClass
	public void generateTestData() {
		
		faker = new Faker();  // providing memory
		userPayload = new user(); // providing memory
		userPayload.setId(faker.idNumber().hashCode()); // generate fake id for us
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)
	public void testCreateUser() {
		
		Response response = userEndPoints.createUser(userPayload);
		response.then().log().all();
		
		// validation using assertion
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is our create user method");
		System.out.println("name "+faker.name().username());
		System.out.println("uname"+this.userPayload.getUsername());
	}
	
	@Test(priority=2)
	public void testGetUser() {
		
		Response response = userEndPoints.createUser(userPayload);
		response.then().log().all();
		
		// validation using assertion
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is our create user method");
		System.out.println("name "+faker.name().username());
		System.out.println("uname"+this.userPayload.getUsername());
	}
	// get, update and delete
	
	@Test(priority=3)
	public void testUpdateUser() {
		userPayload.setFirstName(faker.name().firstName());
		Response response = userEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().all();
		
		// validation using assertion
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is our update user method");
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
//		userPayload.setFirstName(faker.name().firstName());
//		Response response = userEndPoints.deleteUser(this.userPayload.getUsername());
//		response.then().log().all();
		
		// validation using assertion
		
//		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("This is our delete user method");
	}

}
