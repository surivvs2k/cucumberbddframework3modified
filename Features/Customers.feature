Feature: Customers

Background: Below are comon steps for every scenario
		Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard

  Scenario: Add a new Customer
    When User click on customers menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

  Scenario: Search Customer by EMailID
    When User click on customers menu
    And click on customers Menu Item
    And Enter customer EMail
    When click on serach button
    Then User should found EMail in the Seach table
    And close browser

  Scenario: Search Customer by Name
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When click on serach button
    Then User should found Name in the Seach table
    And close browser
