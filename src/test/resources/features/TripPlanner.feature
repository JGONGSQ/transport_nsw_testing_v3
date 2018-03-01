Feature: Make a trip plan

  Scenario: A trip test request can be executed and results returned
    Given Phileas is planning a trip
    When he executes a trip plan from "North Sydney Station" to "Town Hall Station"
    Then a list of trips should be provided