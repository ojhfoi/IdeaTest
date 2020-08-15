@all
@tsum_cabinet
  Feature: Check user personal cabinet
    Scenario: Check personal cabinet
      When Open site
      And go to user personal cabinet
      Given insert user email "test@test.ru" and user password "test"
      Given click on submit button
      When check authorization status and insert email "test@test.ru" if auth fail
