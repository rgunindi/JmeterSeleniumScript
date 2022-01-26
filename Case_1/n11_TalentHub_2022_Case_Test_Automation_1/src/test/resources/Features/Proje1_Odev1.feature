@first_homework
Feature: Click on each of the categories on the https://www.n11.com/kampanyalar page in a loop,
        and the urls containing the details of all the campaigns
        or promotions in each category will be written in a csv or excel

  Rule: Must be done without login

  Scenario Outline: All campaigns or promotions in each category urls with details will be written to a csv or excel
    Given I launch <desired_browser> browser and <env> environment
    When  Go to "https://www.n11.com/kampanyalar"
    And   Inside a loop to each of the categories on the opened page, campaigns or to promotions will be clicked on
    Then  Urls with details will be written to a csv

    Examples:
    |desired_browser|   |env |
    |     Firefox   |   |test|
    |     Chrome    |   |test|
#    |     Edge      |   |test|
                     # |qa-staging-prod|
