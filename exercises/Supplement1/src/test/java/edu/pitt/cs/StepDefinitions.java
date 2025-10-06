package edu.pitt.cs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class StepDefinitions {
	private RentACat r;
	private String listResult;
	private boolean rentResult;
	private boolean returnResult;
	
	// TODO: Add more member variables and methods as necessary

	@Given("a rent-a-cat facility")
	public void aRentACatFacility() {
		r = RentACat.createInstance(InstanceType.IMPL);
	}
	
	@Given("no cats")
	public void noCats() {
		// nothing to do really
	}
	
	@Given("a cat with ID {int} and name {string}")
	public void aCatWithIDAndName(Integer id, String name) {
		r.addCat(Cat.createInstance(InstanceType.IMPL, id, name));
		System.out.println("Created cat " + id + ". " + name);
	}
	
	@When("I list the cat(s)")
	public void iListTheCats() {
		listResult = r.listCats();
	}
	
	@When("I rent cat number {int}")
	public void iRentCatNumber(Integer id) {
		rentResult = r.rentCat(id);
	}
	
	@Then("the listing is: {string}")
	public void theListingIs(String result) {
		assertEquals(result.replaceAll("\\\\n", "\n"), listResult);
	}
	
	@Then("the rent is successful")
	public void theRentIsSuccessful() {
		assertTrue("Expected rent is successful", rentResult);
	}

	@Then("the rent is unsuccessful")
	public void theRentIsUnsuccessful() {
		assertFalse("Expected rent is unsuccessful", rentResult);
	}

	@When("I return cat number {int}")
	public void iReturnCatNumber(Integer id) {
		returnResult = r.returnCat(id);
	}

	@Then("the return is unsuccessful")
	public void theReturnIsUnsuccessful() {
		assertFalse("Expected return is unsuccessful", returnResult);
	}

	@Then("the return is successful")
	public void theReturnIsSuccessful() {
    	assertTrue("Expected return is successful", returnResult);
	}
}
