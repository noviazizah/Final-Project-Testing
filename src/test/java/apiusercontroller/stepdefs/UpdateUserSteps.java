package apiusercontroller.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.assertEquals;

public class UpdateUserSteps {
    private RequestSpecification httpRequest;
    private Response response;

    @Given("I have a user registered on the system")
    public void iHaveAUserRegisteredOnTheSystem() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
        httpRequest = RestAssured.given().header("app-id", "665c257a4ff6ee05ceaa8edf").contentType(ContentType.JSON);
        response = httpRequest.request(Method.GET, "user/60d0fe4f5311236168a109fa");
    }

    @When("I update the user with the title to {string}")
    public void iUpdateTheUserWithTheTitleTo(String newTitle) {
        String requestBody = String.format("{\"title\": \"%s\"}", newTitle);
        response = httpRequest.body(requestBody).put("user/60d0fe4f5311236168a109fa");
    }

    @When("I update the user with the firstName to {string}")
    public void iUpdateTheUserWithTheFirstNameTo(String newFirstName) {
        String requestBody = String.format("{\"firstName\": \"%s\"}", newFirstName);
        response = httpRequest.body(requestBody).put("user/60d0fe4f5311236168a109fa");
    }

    @When("I update the user with the lastName to {string}")
    public void iUpdateTheUserWithTheLastNameTo(String newLastName) {
        String requestBody = String.format("{\"lastName\": \"%s\"}", newLastName);
        response = httpRequest.body(requestBody).put("user/60d0fe4f5311236168a109fa");
    }

    @When("I update the user with the gender to {string}")
    public void iUpdateTheUserWithTheGenderTo(String newGender) {
        String requestBody = String.format("{\"gender\": \"%s\"}", newGender);
        response = httpRequest.body(requestBody).put("user/60d0fe4f5311236168a109fa");
    }

    @When("I update the user with the dateOfBirth to {string}")
    public void iUpdateTheUserWithTheDateOfBirthTo(String newDateOfBirth) {
        String requestBody = String.format("{\"dateOfBirth\": \"%s\"}", newDateOfBirth);
        response = httpRequest.body(requestBody).put("user/60d0fe4f5311236168a109fa");
    }

    @Then("I should receive a success response with status code {int}")
    public void iShouldReceiveASuccessResponseWithStatusCode(int expectedStatusCode) {
        assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the title in the response should reflect the update to {string}")
    public void theTitleInTheResponseShouldReflectTheUpdateTo(String expectedTitle) {
        assertEquals(expectedTitle, response.jsonPath().getString("title"));
    }
}
