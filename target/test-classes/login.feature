Feature: login

  Scenario: valid login
    Given user open orangeHRM application
    When user enter valid username
    And user enter valid password
    And click on login button
    Then account page should be open

  Scenario: invalid login
    Given user open orangeHRM application
#    When user enter valid username
#    And user enter invalid password
    When user enter username as "Admin"
    And user enter password as "admin"
    And   click on login button
    Then warning msg display