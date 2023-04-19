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
    |Key|Value|
    |key|qaclick123|
    |place_id|abb69af48f588ed56d89933e9e0f1355|
