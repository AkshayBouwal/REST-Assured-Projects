package stepDefinitions;

import bodyContent.CreateIssueBody;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import utils.Configurations;
import utils.LoginConfig;

import java.io.File;


public class stepDefinition {

    private static RequestSpecification inputRequest;
    private static Response inputResponse;
    private static String issueID;
    private static Response attachmentResponse;


    @Given("Prepare request specification for Jira API")
    public void prepare_request_specification_for_jira_api() {

        inputRequest = RestAssured.given(LoginConfig.loginSpec())
                .header("Content-Type", "application/json");

    }

    @Given("Add body content in request specification")
    public void add_body_content_in_request_specification() {

        inputRequest = inputRequest.body(CreateIssueBody.body());

    }

    @When("Make post http request call for the API")
    public void make_post_http_request_call_for_the_api() {

        inputResponse = inputRequest
                .when()
                .post("/rest/api/3/issue")
                .then()
                .extract().response();
    }

    @Then("Issue should be created successfully with {int} status code")
    public void issue_should_be_created_successfully_with_status_code(Integer expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, inputResponse.getStatusCode());
    }

    @Given("Get issue id from last scenario")
    public void get_issue_id_from_last_scenario() {

        JsonPath jsonPath = new JsonPath(inputResponse.asString());
        issueID = jsonPath.getString("id");

    }

    @When("Make post http request call to attach screenshot")
    public void make_post_http_request_call_to_attach_screenshot() {

        attachmentResponse = RestAssured.given(LoginConfig.loginSpec())
                .header("X-Atlassian-Token", "no-check")
                .multiPart("file", new File(Configurations.getProperties("imagePath")))
                .when()
                .post("/rest/api/3/issue/" + issueID + "/attachments")
                .then()
                .extract().response();

    }

    @Then("Attachment should be added successfully with {int} status code")
    public void attachment_should_be_added_successfully_with_status_code(Integer expectedStatusCode) {
        Assertions.assertEquals(expectedStatusCode, attachmentResponse.getStatusCode());
    }

}
