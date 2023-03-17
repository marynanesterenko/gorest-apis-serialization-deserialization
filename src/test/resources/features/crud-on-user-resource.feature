Feature: crud operation of the user resource

  Scenario: verify the user is able to be successfully created in the database
    Given user creation request is successful
    When user creation in the Database is verified
    Then delete the user record from the Database

  Scenario: verify existing user record can be retrieved from the database
    Given user creation request is successful and user exists in the Database
    When user unique id is provided and user record is retrieved
    Then  delete the user record from the Database

  Scenario: verify existing user record can be updated
    Given user creation request is successful and user exists in the Database
    And user unique id is provided and user record is retrieved
    When user fields are updated
    And user fields update is verified
    Then delete the user record from the Database

  Scenario: verify the user record can be deleted from the Database
    Given user creation request is successful and user exists in the Database
    And user unique id is provided and user record is retrieved
    When user is deleted
    Then verify that the user no longer exists