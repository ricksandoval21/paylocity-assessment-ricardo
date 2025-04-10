package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import mapping.EmployeeResponseMap;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;

public class StepDefinitionsAPI {

    private SoftAssert softAssert = new SoftAssert();
    private Response response;
    String token;
    String baseUrl = "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/employees";
    private String deletedEmployeeId;

    @Given("I have a valid user")
    public void accessMethod() {
        String authUrl = "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/Account/Login";
        String username = "TestUser741";
        String password = "{1YsCHeW}@Oz";
        token = "Basic VGVzdFVzZXI3NDE6ezFZc0NIZVd9QE96";

        Response response = given()
                .queryParam("Username", username)
                .queryParam("Password", password)
                .header("Authorization", token)
                .when()
                .get(authUrl);
        response.then().statusCode(200);
    }

    @When("I send a POST request to create an employee with the following request {string}")
    public void creatingEmployee(String body) throws IOException {
        response = RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", token)
                .body(readTestDataFileToString(body))
                .when()
                .post(baseUrl);
    }

    @When("I send a PUT request to update an employee with the following request {string}")
    public void updatingEmployee(String body) throws IOException {
        String baseUrl = "https://wmxrwq14uc.execute-api.us-east-1.amazonaws.com/Prod/api/employees";
        response = RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", token)
                .body(readTestDataFileToString(body))
                .when()
                .put(baseUrl);
        response.then().statusCode(200);
    }

    @Then("Validate all fields from response")
    public void validateResponse() {
        RestAssured.defaultParser = Parser.JSON;
        EmployeeResponseMap employee = response.getBody().as(EmployeeResponseMap.class);

        String partitionKey = employee.getPartitionKey();
        String sortKey = employee.getSortKey();
        String username = employee.getUsername();
        String id = employee.getId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int dependants = employee.getDependants();
        float salary = employee.getSalary();
        float gross = employee.getGross();
        float benefitsCost = employee.getBenefitsCost();
        float net = employee.getNet();
        softAssert.assertNotNull(partitionKey, "partitionKey is null");
        softAssert.assertNotNull(sortKey, "sortKey is null");
        softAssert.assertNotNull(username, "username is null");
        softAssert.assertNotNull(id, "id is null");
        softAssert.assertNotNull(firstName, "firstName is null");
        softAssert.assertNotNull(lastName, "lastName is null");
        softAssert.assertTrue(dependants < 32, "dependants is lower than 32 dependants");
        softAssert.assertTrue(salary == 52000, "salary is 0");
        softAssert.assertTrue(gross == 2000, "gross is 0");
        softAssert.assertNotEquals(benefitsCost, 0, "benefitsCost is not equals to 0");
        softAssert.assertNotEquals(net, 0, "net is not equals to 0");
        softAssert.assertAll();
    }

    @Then("Validate all fields from GET ID response")
    public void validateResponseGetId() {
        RestAssured.defaultParser = Parser.JSON;
        EmployeeResponseMap employee = response.getBody().as(EmployeeResponseMap.class);

        String partitionKey = employee.getPartitionKey();
        String sortKey = employee.getSortKey();
        String username = employee.getUsername();
        String id = employee.getId();
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int dependants = employee.getDependants();
        String expiration = employee.getExpiration();//extra field on GET ID
        float salary = employee.getSalary();
        float gross = employee.getGross();
        float benefitsCost = employee.getBenefitsCost();
        float net = employee.getNet();
        softAssert.assertNotNull(partitionKey, "partitionKey is null");
        softAssert.assertNotNull(sortKey, "sortKey is null");
        softAssert.assertNotNull(username, "username is null");
        softAssert.assertNotNull(id, "id is null");
        softAssert.assertNotNull(firstName, "firstName is null");
        softAssert.assertNotNull(lastName, "lastName is null");
        softAssert.assertTrue(dependants < 32, "dependants is lower than 32 dependants");
        softAssert.assertNotNull(expiration, "expiration is null");
        softAssert.assertTrue(salary == 52000, "salary is 0");
        softAssert.assertTrue(gross == 2000, "gross is 0");
        softAssert.assertNotEquals(benefitsCost, 0, "benefitsCost is not equals to 0");
        softAssert.assertNotEquals(net, 0, "net is not equals to 0");
        softAssert.assertAll();
    }

    @Then("Validate employee is correctly updated")
    public void validateUpdatedEmployee() {
        RestAssured.defaultParser = Parser.JSON;
        EmployeeResponseMap employee = response.getBody().as(EmployeeResponseMap.class);

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        int dependants = employee.getDependants();

        //this is hardcoded now, but can be validated with the DB values or another source data
        softAssert.assertEquals(firstName, "Juan","firstName is not the expected one");
        softAssert.assertEquals(lastName, "Kings", "lastName is not the expected one");
        softAssert.assertEquals(dependants, 10, "dependants is not the expected one");
        softAssert.assertAll();
    }

    @Then("I DELETE an employee")
    public void deleteEmployee() {
        RestAssured.defaultParser = Parser.JSON;
        EmployeeResponseMap employee = response.getBody().as(EmployeeResponseMap.class);

        String id = employee.getId();
        this.deletedEmployeeId = id;

        response = RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", token)
                .when()
                .delete(baseUrl+"/"+id);
        response.then().statusCode(200);
    }

    @Then("I send a GET request for a single employee")
    public void getIdEmployee() {
        RestAssured.defaultParser = Parser.JSON;
        EmployeeResponseMap employee = response.getBody().as(EmployeeResponseMap.class);

        String id = employee.getId();
        this.deletedEmployeeId = id;

        response = RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", token)
                .when()
                .get(baseUrl+"/"+id);

        response.then().statusCode(200);
    }

    @Then("I send a GET request for employee list")
    public void getIdEmployeeList() {
        RestAssured.defaultParser = Parser.JSON;
        response = RestAssured
                .given()
                .contentType("application/json")
                .header("Authorization", token)
                .when()
                .get(baseUrl);

        response.then().statusCode(200);
    }

    @Then("Validate employees are on the list")
    public void validateEmployeeList() {
        RestAssured.defaultParser = Parser.JSON;
        List<EmployeeResponseMap> list = Arrays.asList(response.as(EmployeeResponseMap[].class));
        int totalOfEmployees = list.size();

        softAssert.assertTrue(totalOfEmployees > 1, "Employees not created");
    }

    @Then("Validate the deleted employee on list")
    public void deleteEmployeeList() {
        RestAssured.defaultParser = Parser.JSON;
        String id = this.deletedEmployeeId;

        Response response = RestAssured
                .given()
                .header("Authorization", token)
                .when()
                .get(baseUrl + "/" + id);
        response.then().statusCode(200);

        softAssert.assertTrue(response.getStatusCode() == 200, "The status code is not successful");
        String responseBody = response.getBody().asString();
        if (responseBody.isBlank()) {
            softAssert.assertTrue(true, "The employee has been successfully deleted.");
        } else {
            softAssert.fail("The response body should be empty but it contains: " + responseBody);
        }
        softAssert.assertAll();
    }

    //this util action can be in another class but is here for just for the paylocity challenge
    public String readTestDataFileToString(String jsonFile) throws IOException {
            String filePath = "src/test/resources/test-data/" + jsonFile;
            String content = new String(readAllBytes(Paths.get(filePath)));

        return content;
    }
}
