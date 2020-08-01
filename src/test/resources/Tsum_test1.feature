@tsum_gift
Feature: Check Gift card

  Scenario: Check gift card buy
    Given Open site
    Then choose gift card product
    And select image 3 in galery
    And select summ "300000 ₽" on gift card
    Then add product in cart
    And insert buyer name "lkuert", surname "ojhfoi", phone "+71111111111", email "ojhfoi@email.ru"