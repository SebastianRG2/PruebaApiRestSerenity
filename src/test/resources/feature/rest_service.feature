Feature: Register user through api

  Scenario Outline: Single user
    Given <nameActor> create a user with the get method in <baseUrl>
    When User get response <url>
    Then User verifies the response obtained <response>
    Examples:
      | nameActor | baseUrl           | url          | response |
      | User      | https://reqres.in | /api/users/2 | 200      |
      | User      | https://reqres.in | /api/        | 404      |

  Scenario Outline: Resource service
    Given <nameActor> create a user with the get method in <baseUrl>
    When User get resource list <url>
    Then The user verifies the response obtained with their <name>
    Examples:
      | nameActor | baseUrl           | url          | name     |
      | User      | https://reqres.in | /api/unknown | cerulean |

  @Create
  Scenario Outline: Create User
    Given <nameActor> create a user with the get method in <baseUrl>
    When User post response <url>
      | name | <name> |
      | job  | <job>  |
    And Obtain information registered
    Then The user verifies the response is null
    Examples:
      | nameActor | baseUrl           | url        | name     | job    |
      | User      | https://reqres.in | /api/users | morpheus | leader |





