Feature: Make a trip plan

  Scenario: A trip test request cane be executed and results returned
    Given Phileas is planning a trip
    When he executes a trip plan from "Chatswood Station" to "Wynyard Station"
    Then a list of trips should be provided