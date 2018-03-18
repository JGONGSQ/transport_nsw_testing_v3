Feature: Make a trip plan

  Scenario Outline: A trip test request can be executed and results returned as a list of trips
    Given Phileas is planning a trip
    When he executes a trip plan from "<origin>" to "<destination>"
    Then a list of trips should be provided
  Examples:
    | origin                | destination       |
    | North Sydney Station  | Town Hall Station |
    | Chatswood Station     | Wynyard Station   |

