Feature:Test API

Scenario:Test Get API
  Given User send URl Base Url as "https://rahulshettyacademy.com"
  When User sends Query Parameter as
    |Key|Value|
    |key|qaclick123|
    |place_id|952399ca9d81bc5249a04a315fd18d79|
  And User sends Resources as "/maps/api/place/get/json" with call as "Get"
  Then  User expects a Response code of 200
  
Scenario: Test Post API
  Given User send URl Base Url as "https://rahulshettyacademy.com"
  When User sends Query Parameter as
    |Key|Value|
    |key|qaclick123|
  And User sends headers as
    |Key|Value|
    |Content-Type|application/json|
  And User sends body as "post.json"
  And User sends Resources as "/maps/api/place/add/json" with call as "Post"
  Then User expects a Response code of 200

Scenario: Test Put API
  Given User send URl Base Url as "https://rahulshettyacademy.com"
  When User sends Query Parameter as
  |Key      | Value                               |
  |key      | qaclick123                          |
  And User sends headers as
  |Key|Value|
  |Content-Type|application/json|
  And User sends body as "put.json"
  And User sends Resources as "/maps/api/place/update/json" with call as "Put"
  Then User expects a Response code of 200


 Scenario: Test Delete API
    Given User send URl Base Url as "https://rahulshettyacademy.com"
    When User sends Query Parameter as
      |Key      | Value                               |
      |key      | qaclick123                          |
    And User sends headers as
      |Key|Value|
      |Content-Type|application/json|
    And User sends body as "delete.json"
    And User sends Resources as "/maps/api/place/delete/json" with call as "Delete"
    Then User expects a Response code of 200
  
