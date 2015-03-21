package com.contacts.bdd.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.contacts.restcalls.RestClientCalls;
import junit.framework.Assert;

public class restGetSteps{

	String returnedMessage;
	
	@Given("a url $URL")
	public void aUrlToGet(String URL) {
		this.rest_url =  URL;
	}
	
	@When("I request the get method for all contacts")
    public void getContacts() {
		RestClientCalls resp = new RestClientCalls(this.rest_url);
		returnedMessage = resp;
    }
	
	@Then("I should obtain the following JSON message <expectedResult>")
	public void shortenedFormShouldBe(String expectedResult) {
		Assert.assertEquals(returnedMessage, expectedResult);
	}

}
