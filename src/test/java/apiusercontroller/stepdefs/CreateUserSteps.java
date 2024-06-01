package apiusercontroller.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreateUserSteps {

    private RequestSpecification request;
    private Response response;
    private String userPayload;

    @Given("I have access to the User API Controller")
    public void iHaveAccessToTheUserAPI() {
        RestAssured.baseURI = "https://dummyapi.io/data/v1";
        this.request = RestAssured.given().contentType("application/json");
    }

    @Given("I am authorized with a valid app-id {string}")
    public void iHaveAValidAppId(String appID) {
        this.request.header("app-id", appID);
    }

    @Given("I have a user payload with title {string} and other required fields")
    public void iHaveAUserPayloadWithTitleAndOtherRequiredFields(String title) {
        this.userPayload = "{\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"firstName\": \"Alex\",\n" +
                "  \"lastName\": \"Gonzales\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"alex.gonzales@example.com\",\n" +
                "  \"dateOfBirth\": \"1990-01-01\",\n" +
                "  \"phone\": \"123456789\",\n" +
                "  \"picture\": \"http://example.com/picture.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"+7:00\"\n" +
                "  }\n" +
                "}";
    }

    @Given("I have a user payload with firstName length between 2 and 50")
    public void iHaveAUserPayloadWithFirstNameLengthBetween2And50() {
        this.userPayload = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Johnathan\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"johnathandoe@example.com\",\n" +
                "  \"dateOfBirth\": \"1985-07-15\",\n" +
                "  \"phone\": \"777777777\",\n" +
                "  \"picture\": \"http://example.com/picture6.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"303 Oak St\",\n" +
                "    \"city\": \"San Francisco\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"-7:00\"\n" +
                "  }\n" +
                "}";
    }

    @Given("I have a user payload with email as string")
    public void iHaveAUserPayloadWithEmailAsString() {
        this.userPayload = "{\n" +
                "  \"title\": \"mr\",\n" +
                "  \"firstName\": \"Johnie\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"johniedoe@example.com\",\n" +
                "  \"dateOfBirth\": \"1987-11-20\",\n" +
                "  \"phone\": \"666666666\",\n" +
                "  \"picture\": \"http://example.com/picture8.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"505 Maple St\",\n" +
                "    \"city\": \"Miami\",\n" +
                "    \"state\": \"FL\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"-5:00\"\n" +
                "  }\n" +
                "}";
    }

    @Given("I have a user payload with dateOfBirth as ISO date")
    public void iHaveAUserPayloadWithDateOfBirthAsISODate() {
        this.userPayload = "{\n" +
                "  \"title\": \"mrs\",\n" +
                "  \"firstName\": \"Jeane\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"jeanedoe@example.com\",\n" +
                "  \"dateOfBirth\": \"1993-12-15\",\n" +
                "  \"phone\": \"444444444\",\n" +
                "  \"picture\": \"http://example.com/picture9.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"606 Pine St\",\n" +
                "    \"city\": \"Denver\",\n" +
                "    \"state\": \"CO\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"-7:00\"\n" +
                "  }\n" +
                "}";
    }

    @Given("I have a user payload with phone number in any format")
    public void iHaveAUserPayloadWithPhoneNumberInAnyFormat() {
        this.userPayload = "{\n" +
                "  \"title\": \"miss\",\n" +
                "  \"firstName\": \"Janneth\",\n" +
                "  \"lastName\": \"Stuart\",\n" +
                "  \"gender\": \"female\",\n" +
                "  \"email\": \"janneth.stuart@example.com\",\n" +
                "  \"dateOfBirth\": \"1990-01-01\",\n" +
                "  \"phone\": \"123-456-7890\",\n" +
                "  \"picture\": \"http://example.com/picture1.jpg\",\n" +
                "  \"location\": {\n" +
                "    \"street\": \"123 Main St\",\n" +
                "    \"city\": \"New York\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"country\": \"USA\",\n" +
                "    \"timezone\": \"+7:00\"\n" +
                "  }\n" +
                "}";
    }

    @When("I send a POST request to {string}")
    public void iSendAPOSTRequestTo(String path) {
        response = this.request.body(userPayload).post(path);
    }

    @Then("I should receive a successful response with the status code {int}")
    public void iShouldReceiveSuccessWithStatusCode(int statusCode) {
        System.out.println("Response: " + response.getBody().asString());
        assertThat(response.getStatusCode(), equalTo(statusCode));
    }

    @Then("the response should display the user id and details")
    public void theResponseShouldDisplayTheUserIdAndDetails() {
        assertThat(response.getBody().asString(), containsString("id"));
        assertThat(response.getBody().asString(), containsString("firstName"));
        assertThat(response.getBody().asString(), containsString("lastName"));
    }
}
