package apiusercontroller.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UpdateUserSteps {

    private RequestSpecification request;
    private Response response;

    @Given("access to the User API is confirmed")
    public void accessToTheUserAPIIsConfirmed() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        this.request = RestAssured.given().contentType("application/json");
    }
    

    @Given("the app-id {string} is authorized in the header")
    public void theAppIdIsAuthorizedInTheHeader(String appId) {
        this.request.header("app-id", appId);
    }

    @Given("the user ID {string} is valid")
    public void theUserIDIsValid(String userId) {
        this.request.pathParam("id", userId);
    }

    @When("I send a PUT request to modify the user's {string} to {string}")
    public void iSendAPUTRequestToModifyTheUsersFieldTo(String field, String newValue) {
        String path = "/user/{id}";
        String body = String.format("{\"%s\": \"%s\"}", field, newValue);
        response = this.request.body(body).put(path);
    }

    @Then("the response should have a status code of {int}")
    public void theResponseShouldHaveAStatusCodeOf(int statusCode) {
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the {string} in the response should reflect the update to {string}")
    public void theFieldInTheResponseShouldReflectTheUpdateTo(String field, String expectedValue) {
        assertThat(response.getBody().jsonPath().getString(field), equalTo(expectedValue));
    }

    @Then("the response should confirm the {string} has been updated to {string}")
    public void theResponseShouldConfirmTheFieldHasBeenUpdatedTo(String field, String expectedValue) {
        assertThat(response.getBody().jsonPath().getString(field), equalTo(expectedValue));
    }
}
