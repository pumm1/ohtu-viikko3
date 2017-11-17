Feature: A new user account can be created if a proper unused username and password are given

  #eka tehty!
  Scenario: creation is successful with valid username and password
    Given command new user is selected
    When username "mikko" and password "s4lasana" are given
    Then system will respond with "new user registered"

  #toka tehty
  Scenario: creation fails with already taken username and valid password
    Given command new user is selected
    When username "mikko" and password "s4lasana" are given
    And username "mikko" and password "s4lasana" are given
    Then system will respond with "new user not registered";

  #kolmas tehty
  Scenario: creation fails with too short username and valid password
    Given command new user is selected
    When username "ae" and password "s4lasana" are given
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and too short password
    Given command new user is selected
    When username "mikko" and password "s4lis" are given
    Then system will respond with "new user not registered"

  Scenario: creation fails with valid username and password enough long but consisting of only letters
    Given command new user is selected
    When username "mikko" and password "salasana" are given
    Then system will respond with "new user not registered"

  Scenario: can login with successfully generated account
    Given user "eero" with password "salainen1" is created
    And command login is selected
    When username "eero" with password "salainen1" are given
    Then system will respond with "logged in"
