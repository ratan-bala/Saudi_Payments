package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RahulShettyStepdefinition {
    RequestSpecification requestSpecification;
    Response response;

    /**
     * This method take a String as the URL and constructs a Request Specification
     * @param Url
     */
    @Given("User send URl Base Url as {string}")
    public void User_send_URl_Base_Url_as(String Url){
        requestSpecification=given().log().all().baseUri(Url);


    }

    /**
     * This method take data in a data table format with key value pair and then converts the data table into
     * a List of String map. It later iterates using a for loop and adds the data as qurey parameters to the existing
     * Request specification.
     * @param Table
     */
    @When("User sends Query Parameter as")
    public void User_sends_Query_Parameter_as(io.cucumber.datatable.DataTable Table){
        List<Map<String, String>> data=Table.asMaps(String.class, String.class);
        for(Map<String,String> pairs:data){
            requestSpecification=requestSpecification.queryParams(pairs.get("Key"),pairs.get("Value"));
        }

    }

    /**
     * This method take data in a data table format with key value pair and then converts the data table into
     * a List of String map. It later iterates using a for loop and adds the data as headers to the existing
     * Request specification.
     * @param dataTable
     */
    @When("User sends headers as")
    public void User_sends_header_as(io.cucumber.datatable.DataTable dataTable){
        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
        for(Map<String,String> pairs:data){
            requestSpecification=requestSpecification.headers(pairs.get("Key"),pairs.get("Value"));
        }

    }

    @When("User sends body as {string}")
    public void User_sends_body_as(String body) throws IOException {
        requestSpecification=requestSpecification.body(new String(Files.readAllBytes(Paths.get("src/main/java/Request_body/"+body))));

    }

    /**
     * This method takes Resources and the call as String Parameters and makes the corresponding call along
     * with the resources and adds it to the existing Request Specification and returns a response
     * @param resource
     * @param call
     */
    @When("User sends Resources as {string} with call as {string}")
    public void User_sends_Resources_as_with_call_as(String resource,String call){
        if(call.equalsIgnoreCase("get")){
            response=requestSpecification.when().get(resource);
        }
        else if(call.equalsIgnoreCase("post")){
            response=requestSpecification.when().post(resource);
        }
        else if(call.equalsIgnoreCase("put")){
            response=requestSpecification.when().put(resource);
        }
        else if(call.equalsIgnoreCase("patch")){
            response=requestSpecification.when().patch(resource);
        }
        else if(call.equalsIgnoreCase("delete")){
            response=requestSpecification.when().delete(resource);
        }
    }

    /**
     * This method take the expected status code as an int parameter and checks it against the code of the
     * response.
     * @param code
     */
    @Then("User expects a Response code of {int}")
    public void User_expects_a_Response_code_of(int code){
        response =response.then().statusCode(code).log().all().extract().response();
    }

}
