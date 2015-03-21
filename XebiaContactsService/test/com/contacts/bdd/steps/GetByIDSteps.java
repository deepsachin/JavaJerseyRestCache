package com.contacts.bdd.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.contacts.restcalls.RestClientCalls;
import junit.framework.Assert;

public class GetByIDSteps{

	String returnedMessage;
	
	@Given("a url with id $URL")
	public void aUrlToGet(String URL) {
		this.rest_url =  URL;
	}
	
	@When("I request the get method for single contact")
    public void getContacts() {
		RestClientCalls resp = new RestClientCalls(this.rest_url);
		returnedMessage = resp;
    }
	
	@Then("I should obtain the following JSON message <expectedResult>")
	public void shortenedFormShouldBe(String expectedResult) {
		Assert.assertEquals(returnedMessage, expectedResult);
		
	}

}
