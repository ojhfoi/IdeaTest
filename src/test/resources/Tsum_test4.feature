@tsum_clothe

  Feature: Check clothe product

    Scenario: Check clothe product
      Given Open site
      And go to clothe category
      Then go to shorts product category
      And select jeans shorts product category
      When set filter "Бренд" active
      Given set brand filter by brand "Chloé"
      Then set other filter "В наличии"
      And select dress product category
