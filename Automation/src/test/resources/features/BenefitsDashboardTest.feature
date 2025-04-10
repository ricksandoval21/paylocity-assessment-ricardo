Feature: API Test for Paylocity

  Background: Generate a new access token
    Given I have a valid user

  Scenario: Create a new employee - POST
    When I send a POST request to create an employee with the following request "API-POST.json"
    Then Validate all fields from response

  Scenario: Update an employee - PUT
    When I send a PUT request to update an employee with the following request "API-PUT.json"
    Then Validate employee is correctly updated

  Scenario: Delete an employee - DEL
    When I send a POST request to create an employee with the following request "API-DELETE.json"
    Then I DELETE an employee
    And Validate the deleted employee on list

  Scenario: Get an employee - GET ID
    When I send a POST request to create an employee with the following request "API-GETID.json"
    Then I send a GET request for a single employee
    And Validate all fields from GET ID response

  Scenario: Get all employees - GET LIST
    When I send a POST request to create an employee with the following request "API-GETLIST1.json"
    Then I send a POST request to create an employee with the following request "API-GETLIST2.json"
    And I send a GET request for employee list
    Then Validate employees are on the list