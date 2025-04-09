# Paylocity – Assessment Report

## 🧾 Paylocity – Bug Assessment Report

Ricardo Sandoval

**Date:** 04/07/2025

**Scope:** UI and API testing

---

### 🧭 Overview

This report summarizes the findings from manual exploratory testing of Paylocity’s UI and API. The main objective was to identify functional and usability issues that could impact user experience or system reliability.

---

### 📊 Bug Summary

| ID | Type | Component | Severity | Summary | Status |
| --- | --- | --- | --- | --- | --- |
| UI-001 | UI | “Add Employee” window | Medium | Not alerts or warning displayed when a field is required (Adding or Updating) | Open |
| UI-002 | UI | “Add Employee” window | Medium | Not alerts or warning displayed about the limit value or when is above the limit on “Dependents” field. 32 Max (Adding or Updating) | Open |
| UI-003 | UI | “Add Employee” window | Medium | Not alerts or warning displayed about the limit value or when is above the limit on “First Name” and “Last Name” field. 50 Max (Adding or Updating) | Open |
| UI-004 | UI | Benefits Dashboard | High | The table layout breaks when long names are displayed | Open |
| UI-005 | UI | Benefits Dashboard | Critical | After 6 mins of inactivity the system starts failing | Open |
| UI-006 | UI | “Add Employee” window | Critical | Able to add employees with same information | Open |
| UI-007 | UI | “Add Employee” window | High | Able to add numeric values in First Name and Last Name fields | Open |
| UI-008 | UI | “Add Employee” window | Medium | Able to add special characters in First Name and Last Name fields | Open |
| UI-009 | UI | “Add Employee” window | Medium | Able to add more than 3 dependents | Open |
| UI-010 | UI | “Add Employee” window | Critical | Click twice on Add Employee button is creating duplicates | Open |
| UI-011 | UI | Benefits Dashboard | Medium | Table breaks because responsive issue | Open |
| API-001 | API | POST Add Employee | Medium | Expected 201 code | Open |
| API-002 | API | POST Add Employee | Medium | Blank space allowed in Field Name and Last Name. | Open |
| API-003 | API | POST Add Employee | Medium | Nulls, Strings and empties values on Dependents  is responding with 405 Error Code | Open |
| API-004 | API | POST Add Employee | Critical | Able to create duplicates values | Open |
| API-005 | API | POST Add Employee | Medium | Sending the value as numeric in First Name and Last Name is responding with 405 Error Code | Open |
| API-006 | API | GET Get Employee | Medium | Getting 500 Error Message when Id is empty, zero, negative, string or invalid. | Open |
| API-007 | API | GET Get Employee | High | Getting 200 status code with empty response when Id is valid format but doesn’t exists or was already deleted | Open |
| API-008 | API | GET Get Employee | Medium | Getting 400 Bad Request but no error message displayed when Id contains special characters | Open |
| API-009 | API | PUT Update Employee | High | Able to update an Employee with an incorrect employee ID | Open |
| API-010 | API | PUT Update Employee | High | Able to update an Employee without “Dependents” field | Open |
| API-011 | API | PUT Update Employee | High | ID field does not request it as required - Responding with 405 Error Code | Open |
| API-012 | API | PUT Update Employee | Medium | Invalid, Numeric and Special Characters values in ID field is responding with 405 Error Code - Not error message | Open |
| API-013 | API | PUT Update Employee | High | Null value on “Dependents” is responding with 405 Error Code - Not error message | Open |
| API-014 | API | DEL Delete Employee | High | ID with a valid format value but doesn’t exists is responding with a 200 status code | Open |
| API-015 | API | DEL Delete Employee | Medium | ID with special characters is responding with 400 bad request but is not showing any error message | Open |
| API-016 | API | DEL Delete Employee | Medium | Numeric, negative or String ID values is responding with a 405 Error code | Open |

> 🧮 Total Bugs: 27
> 
> 
> 🎯 Distribution: 11 UI, 16 API
> 
> 🚨 Severity: 4 Critical, 8 High, 15 Medium
> 

---

### 🐞 Detailed Bug Reports

### 🔹 UI-001 – Not alerts or warning displayed when a field is required (Adding or Updating)

- **Component:** “Add Employee” window
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on "Add Employee" button
    3. Do not add any values in the fields
    4. Click on “Add”
- **Expected:** Alert or warning should be displayed for required fields
- **Actual:** It doesn't show anything and the button doesn't do anything
- **Evidence:** `EVIDENCE/UI/UI-001.png`

---

### 🔹 UI-002 – Not alerts or warning displayed about the limit value or when is above the limit on “Dependents” field. 32 Max (Adding or Updating)

- **Component:** “Add Employee” window
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on "Add Employee" button
    3. Add any First Name and Last Name
    4. Add a number greater than 32 value
    5. Click on “Add”
- **Expected:** Alert or warning should be displayed for the limit value
- **Actual:** It doesn't show anything and the button doesn't do anything
- **Evidence:** `EVIDENCE/UI/UI-002.png`

---

### 🔹 UI-003 – Not alerts or warning displayed about the limit value or when is above the limit on “First Name” and “Last Name” field. 50 Max (Adding or Updating)

- **Component:** “Add Employee” window
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on "Add Employee" button
    3. Add any First Name and Last Name greater than 50 characters
    4. Add any dependent value
    5. Click on “Add”
- **Expected:** Alert or warning should be displayed for the limit value on First Name and Last Name
- **Actual:** It doesn't show anything and the button doesn't do anything
- **Evidence:** `EVIDENCE/UI/UI-003.png`

---

### 🔹 UI-004 – The table layout breaks when long names are displayed

- **Component:** Benefits Dashboard
- **Severity:** High
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on "Add Employee" button
    3. Add any First Name and Last Name greater than 30 characters and lower than 50 characters
    4. Add any dependent value
    5. Click on “Add”
    6. Validate the table with long names added
- **Expected:** Name should be displayed without affecting the table
- **Actual:** Table layout breaks
- **Evidence:** `EVIDENCE/UI/UI-004.png`

---

### 🔹 UI-005 – After 6 mins of inactivity the system starts failing

- **Component:** Benefits Dashboard
- **Severity:** Critical
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Stay inactive for more than 6mins
    3. Try to Add, Update or Delete any record 
- **Expected:** The system must continue to work correctly
- **Actual:** Not able to add, update or delete any employee and after reloading the table dissapears
- **Evidence:** `EVIDENCE/UI/UI-005.png`

---

### 🔹 UI-006 – Able to add employees with same information

- **Component:** “Add Employee” window
- **Severity:** Critical
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on “Add Employee”
    3. Add a valid First Name, Last Name and Dependents number
    4. Click on “Add”
    5. Click again on “Add Employee”
    6. Add the same values for First Name, Last Name and Dependents
- **Expected:** Shouldn’t be able to create duplicates records
- **Actual:** Able to create employees with same information
- **Evidence:** `EVIDENCE/UI/UI-006.png`

---

### 🔹 UI-007 – Able to add numeric values in First Name and Last Name fields

- **Component:** “Add Employee” window
- **Severity:** High
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on “Add Employee”
    3. Add a numeric value on First Name and Last Name
    4. Click on “Add”
- **Expected:** Shouldn’t be able to create employee with numeric values
- **Actual:** Able to create employees with numeric values on First Name and Last Name
- **Evidence:** `EVIDENCE/UI/UI-007.png`

---

### 🔹 UI-008 – Able to add special characters in First Name and Last Name fields

- **Component:** “Add Employee” window
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on “Add Employee”
    3. Add a special characters on First Name and Last Name
    4. Click on “Add”
- **Expected:** Shouldn’t be able to create employee with special characters values
- **Actual:** Able to create employees with special characters values on First Name and Last Name
- **Evidence:** `EVIDENCE/UI/UI-008.png`

---

### 🔹 UI-009 – Able to add more than 3 dependents

- **Component:** “Add Employee” window
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on “Add Employee”
    3. Add any First Name and Last Name
    4. Add more than 3 dependents
    5. Click on “Add”
- **Expected:** Shouldn’t be able to create more than 3 dependents per employee
- **Actual:** Able to create more than 3 dependents
- **Evidence:** `EVIDENCE/UI/UI-009.png`
- **Note:** This could be deprecated if the maximum value can be 32

---

### 🔹 UI-010 – Click twice on Add Employee button is creating duplicates

- **Component:** “Add Employee” window
- **Severity:** Critical
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Click on “Add Employee”
    3. Add any First Name, Last Name and Dependents
    4. Click twice on “Add” button
    5. Validate the records created
- **Expected:** Only one employee should be created
- **Actual:** Duplicate employee created when clicking twice on Add button
- **Evidence:** `EVIDENCE/UI/UI-010.png`

---

### 🔹 UI-011 – Table breaks because responsive issue

- **Component:** Benefits Dashboard
- **Severity:** Medium
- **Environment:** Chrome v 134.0.6998.178, Windows 11
- **Pre-conditions:** Valid Credentials for Paylocity Benefits Dashboard
- **Steps to Reproduce:**
    1. Go to Paylocity Benefits Dashboard
    2. Minimize the browser window
    3. Validate the table is displaying correctly
- **Expected:** Table should be correctly displayed
- **Actual:** Table layout is breaking and is not correctly displayed
- **Evidence:** `EVIDENCE/UI/UI-011.png`

---

### 🔹 API-001 – Expected 201 code

- **Endpoint:** POST /Prod/api/employees
- **Severity:** Medium
- **Request Payload:**

```json
{
    "firstName": "Mark",
    "lastName": "Smith",
    "dependants": 3
}
```

- **Expected:** 201 Created
- **Actual:** 200 OK
- **Evidence:** `EVIDENCE/API/API-001.png`

---

### 🔹 API-002 – Blank space allowed in Field Name and Last Name.

- **Endpoint:** POST /Prod/api/employees
- **Severity:** Medium
- **Request Payload:**

```json
{
    "firstName": "          Mark",
    "lastName": "       Smith",
    "dependants": 3
}
```

- **Expected:** Error message should be displayed to not allow blank spaces
- **Actual:** 200 OK Created with blank spaces
- **Evidence:** `EVIDENCE/API/API-002.png`

---

### 🔹 API-003 – Nulls, Strings and empties values on Dependents  is responding with 405 Error Code

- **Endpoint:** POST /Prod/api/employees
- **Severity:** Medium
- **Request Payload:**

```json
{
    "firstName": "Mark",
    "lastName": "Smith",
    "dependants": null
}
```

- **Expected:** Error message displayed to not allow Nulls, Strings or Empties values
- **Actual:** 405 Error code displayed
- **Evidence:** `EVIDENCE/API/API-003.png`

---

### 🔹 API-004 – Able to create duplicates values

- **Endpoint:** POST /Prod/api/employees
- **Severity:** Critical
- **Request Payload:**

```json
{
    "firstName": "Mark",
    "lastName": "Smith",
    "dependants": 3
}
```

- **Expected:** Shouldn’t be able to create employees with same information
- **Actual:** We are able to create an Employee with the same values
- **Evidence:** `EVIDENCE/API/API-004.png`

---

### 🔹 API-005 – Sending the value as numeric in First Name and Last Name is responding with 405 Error Code

- **Endpoint:** POST /Prod/api/employees
- **Severity:** Medium
- **Request Payload:**

```json
{
    "firstName": 123,
    "lastName": 456,
    "dependants": 3
}
```

- **Expected:** The error must be properly handled and display the specific error
- **Actual:** 405 Error Code Displayed
- **Evidence:** `EVIDENCE/API/API-005.png`

---

### 🔹 API-006 – Getting 500 Error Message when Id is empty, zero, negative, string or invalid.

- **Endpoint:** GET Get Employee
- **Severity:** Medium
- **Request URL:**

```json
{BasePath}/Prod/api/employees/000
```

- **Expected:** The error must be handled and shows the expected error
- **Actual:** 500 Internal Server Error is displayed
- **Evidence:** `EVIDENCE/API/API-006.png`

---

### 🔹 API-007 – Getting 200 status code with empty response when Id is valid format but doesn’t exists or was already deleted

- **Endpoint:** GET Get Employee
- **Severity:** High
- **Request URL:**

```json
{BasePath}/Prod/api/employees/848e3dc9-df21-4a1b-8be3-772db5eec026
```

- **Expected:** The ID must be correct and the system must handle it to display an error when it is not (Error 404 probably should be the best option)
- **Actual:** 200 Status code
- **Evidence:** `EVIDENCE/API/API-007.png`

---

### 🔹 API-008 – Getting 400 Bad Request but no error message displayed when Id contains special characters

- **Endpoint:** GET Get Employee
- **Severity:** Medium
- **Request URL:**

```json
{BasePath}/Prod/api/employees/848e3dc9-df21-4a1b-8be3-772db5eec0$%
```

- **Expected:** Error message must be displayed
- **Actual:** 400 Status code but not error message displayed
- **Evidence:** `EVIDENCE/API/API-008.png`

---

### 🔹 API-009 – Able to update an Employee with an incorrect employee ID

- **Endpoint:** PUT Update Employee
- **Severity:** High
- **Request Payload:**

```json
{
		"id" : "848e3dc9-df21-4a1b-8be3-772db5eec026",
    "firstName": "Joseph",
    "lastName": "Conrad",
    "dependants": 10
}
```

- **Expected:** You should not be able to update a record without the correct ID
- **Actual:** Able to update with an incorrect ID (200 Status code)
- **Evidence:** `EVIDENCE/API/API-009.png`

---

### 🔹 API-010 – Able to update an Employee without “Dependents” field

- **Endpoint:** PUT Update Employee
- **Severity:** High
- **Request Payload:**

```json
{
		"id" : "848e3dc9-df21-4a1b-8be3-772db5eec026",
    "firstName": "Joseph",
    "lastName": "Conrad"
}
```

- **Expected:** You should not be able to update a record without “Dependents” field in request
- **Actual:** Able to update without Dependents field in request (200 Status code)
- **Evidence:** `EVIDENCE/API/API-010.png`

---

### 🔹 API-011 – ID field does not request it as required - Responding with 405 Error Code

- **Endpoint:** PUT Update Employee
- **Severity:** High
- **Request Payload:**

```json
{
    "firstName": "Joseph",
    "lastName": "Conrad",
    "dependents" : 3
}
```

- **Expected:** Error message should be responded when ID is not in the request
- **Actual:** Getting 405 Error code and not showing error message for the required field
- **Evidence:** `EVIDENCE/API/API-011.png`

---

### 🔹 API-012 – Invalid, Numeric and Special Characters values in ID field is responding with 405 Error Code - Not error message

- **Endpoint:** PUT Update Employee
- **Severity:** Medium
- **Request Payload:**

```json
{
		"id" : 123,
    "firstName": "Joseph",
    "lastName": "Conrad",
    "dependents" : 3
}
```

- **Expected:** Error message should be responded when ID is not correct or valid type
- **Actual:** Getting 405 Error code and not showing error message for specific error
- **Evidence:** `EVIDENCE/API/API-012.png`

---

### 🔹 API-013 – Null value on “Dependents” is responding with 405 Error Code - Not error message

- **Endpoint:** PUT Update Employee
- **Severity:** Medium
- **Request Payload:**

```json
{
		"id" : "848e3dc9-df21-4a1b-8be3-772db5eec027",
    "firstName": "Joseph",
    "lastName": "Conrad",
    "dependents" : null
}
```

- **Expected:** Error message should be responded when Dependents is null
- **Actual:** Getting 405 Error code and not showing error message for specific error
- **Evidence:** `EVIDENCE/API/API-013.png`

---

### 🔹 API-014 – ID with a valid format value but doesn’t exists is responding with a 200 status code

- **Endpoint:** DEL Delete Employee
- **Severity:** High
- **Request URL:**

```json
{BasePath}/Prod/api/employees/848e3dc9-df21-4a1b-8be3-772db5eec066
```

- **Expected:** The ID must be correct and the system must handle it to display an error when it is not (Error 404 probably should be the best option)
- **Actual:** 200 Status code
- **Evidence:** `EVIDENCE/API/API-014.png`

---

### 🔹 API-015 – ID with special characters is responding with 400 bad request but is not showing any error message

- **Endpoint:** DEL Delete Employee
- **Severity:** Medium
- **Request URL:**

```json
{BasePath}/Prod/api/employees/848e3dc9-df21-4a1b-8be3-772db5eec0$%
```

- **Expected:** The ID must be correct and the system must handle it to display an error when it is not (Error 404 probably should be the best option)
- **Actual:** 400 Status code but not error message displayed
- **Evidence:** `EVIDENCE/API/API-015.png`

---

### 🔹 API-016 – Numeric, negative or String ID values is responding with a 405 Error code

- **Endpoint:** DEL Delete Employee
- **Severity:** Medium
- **Request URL:**

```json
{BasePath}/Prod/api/employees/123456789
```

- **Expected:** Error message should be responded when id is not correct or valid
- **Actual:** Getting 405 Error code and not showing error message for specific error
- **Evidence:** `EVIDENCE/API/API-016.png`
