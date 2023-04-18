package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RahulShettyStepdefinition {
    RequestSpecification requestSpecification;
    Response response;
    @Given("User send URl Base Url as {string}")
    public void User_send_URl_Base_Url_as(String Url){
        requestSpecification=given().log().all().baseUri(Url);
    }
    @When("User sends Query Parameter as")
    public void User_sends_Query_Parameter_as(io.cucumber.datatable.DataTable dataTable){
        List<Map<String, String>> data=dataTable.asMaps(String.class, String.class);
        for(Map<String,String> pairs:data){
            requestSpecification=requestSpecification.queryParams(pairs.get("Key"),pairs.get("Value"));
        }

    }
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
    @Then("User expects a Response code of {int}")
    public void User_expects_a_Response_code_of(int code){
        response =response.then().statusCode(code).log().all().extract().response();
    }

}
