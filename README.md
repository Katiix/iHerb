README

INTRODUCTION

This document is designed to guide and maintain the overall process of software testing for the iHerb mobile application for Android. iHerb is an ecommerce mobile application for purchasing health and cosmetics products. It has different features and modules like Region/Language confirmation, Login/Registration screen, Search, Filter, Cart, Reviews, Q&A, My Account, Orders and so on.

MAIN PART

DESCRIPTION

For the purpose of testing only 5 modules have been chosen: Region confirmation tests, Login/Registration tests, Search tests, Filter tests and Cart tests. Additional test cases have also been created for testing of navigation. 

Region confirmation screen consists of several fields like country, language selection, zip code, currency and units of measure. 

Login/Registration screens are used for user authentication.

Search screen consists of a search bar and search results.

Filter screen allows to filter results by different categories, hide those out of stock, sort by rating and so on.

Cart screen is used for checking the products added to cart and waiting for checkout. Users can remove the items from the cart, add quantity and check its price.

Navigation through the application is done by clicking on the bottom menu icons.

For each module at least 1 positive and 1 negative test case have been prepared. 
For the purpose of automation testing a set of test cases have been chosen validating users interactions, data submitting, verification of fields and actions. 


	The project has been added to the GitHub repository: https://github.com/Katiix/iHerb. 
 The structure of the project:
 
build.gradle file is a configuration file for the project build, dependencies and tasks;

src folder contains 2 folders: 

--main with configuration and screens packages;

--test with only test classes and resources folder.


INSTRUCTIONS FOR TEST SUITES RUN

The automation project has been prepared using Appium driver on server v.1.15.1, IntelliJ IDEA IDE, TestNG for tests organization and Gradle for project build. The emulation of Android 8.0 mobile device is run on Android studio. 


To run the tests in Windows enter the following commands to the IntelliJ IDEA terminal: 

./gradlew clean smoke                      // to run all test suites from the group “smoke”

./gradlew clean positive                   // to run only positive scenarios

./gradlew clean negative	         // to run only negative scenarios

Pay attention! 
For the registration success test scenarios there’s a need to use a temporary generated email available on: https://temp-mail.org/en/

CONCLUSION

The testing of iHerb Android application exposed several problems that occurred during automation testing, like:

--unavailability of decent locators - for example some elements have only xpath available which is not a good option if the structure of DOM changes;

--Appium server crashes with an error “socket hang up”;

--entering invalid data to the search bar is challenging, better do it manually.

A bug or rather usability improvement has been found during navigation testing. When a user tries to search for a product and clicks on reviews/orders/blog tab he should be able to narrow his search results only for reviews/orders/blog pages but it’s not that obvious. 

In general, the task to create an automated test suite for a mobile application using Appium has been completed successfully. 


Author: Skyba Kateryna				
Date: 14.06.23


