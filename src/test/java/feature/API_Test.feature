Feature:Test API

Scenario:Test Get API
Given User send URl Base Url as "https://rahulshettyacademy.com"
When User sends Query Parameter as
|Key|Value|
|key|qaclick123|
|place_id|afa72b3babb7f2f24c7f2566fa086b9d|
And User sends Resources as "/maps/api/place/get/json" with call as "Get"

Then  User expects a Response code of 200