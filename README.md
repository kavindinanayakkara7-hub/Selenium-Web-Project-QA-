# DemoBlaze Selenium Java Automation Project

## Unit

HF2W - Software Engineering II
Software Testing, Quality Assurance and Maintenance

## Project

DemoBlaze Web Store Selenium Java Automation

## Technologies

- Java 11
- Maven
- Selenium WebDriver
- TestNG
- Google Chrome
- IntelliJ IDEA

## Website

https://www.demoblaze.com/

## Database

No database is required for this project.

This project is focused on UI automation testing using Selenium WebDriver.

## Test Scenarios

### TC01 - Home Page Smoke Test

Verify:

- Page title is not empty
- PRODUCT STORE heading is displayed
- Phones category is displayed

### TC02 - Product Selection

Steps:

1. Open DemoBlaze
2. Select Phones
3. Select Samsung galaxy s6
4. Verify product heading
5. Print product price

### TC03 - Add To Cart

Steps:

1. Open Samsung galaxy s6
2. Click Add to cart
3. Wait for JavaScript alert
4. Print alert message
5. Accept alert

### TC04 - Cart Management

Steps:

1. Add Samsung galaxy s6
2. Add Nokia lumia 1520
3. Open cart
4. Count cart rows
5. Print product names and prices
6. Remove Nokia lumia 1520
7. Verify one product remains
8. Verify Samsung galaxy s6 remains
9. Verify cart total

### TC05 - Checkout Validation

Invalid scenario:

- Submit checkout form without mandatory details
- Verify validation alert

Valid scenario:

- Name: Test Student
- Country: Sri Lanka
- City: Colombo
- Credit Card: 4111111111111111
- Month: 12
- Year: 2027

Verify purchase success message.

## How To Run

### Option 1 - IntelliJ IDEA

1. Open IntelliJ IDEA
2. Open this Maven project
3. Wait for Maven dependencies to download
4. Open DemoBlazeTests.java
5. Right click
6. Select Run 'DemoBlazeTests'

### Option 2 - Maven CMD

Open CMD in project folder.

Run:

mvn clean test

## Test Results

Expected:

Tests run: 5
Failures: 0
Errors: 0

## Notes

DemoBlaze is a public demonstration website.

The website data and HTML structure may change.

All checkout information is fictitious test data.

No real payment information is used.

No database is used.