Feature: Testing Google search fucntionality

#Scenario: Searching Selenium Interview Questions
#Given User is on google search page
#When User types "Selenium Interview Question" in the search input field
#And user pressed enter button
#Then User should navigate to search result page with title "Selenium Interview Question"
#And close the browser

Scenario Outline: Searching <text> in google
Given User is on google search page
When User types <text> in the search input field in google
And user pressed enter button
Then User should navigate to search result page with title <text> on google
And close the browser
Examples:
|text|
|Selenium Interview Question|
|Manual Interview Question|
|API Interview Question|