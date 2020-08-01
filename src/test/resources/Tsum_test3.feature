@tsum_shoes
  
  Feature: Check Shoes product category
    Scenario: Check shoes
      Given Open site
      When go to shoes category
      Then choose sneakers category
      When set filter "Размеры" active
      And choose shoes size at "39"
      And go to page 9