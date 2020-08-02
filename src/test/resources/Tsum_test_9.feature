@tsum_cart
  Feature: Check add product in cart and remove it from cart
    Scenario: Check cart
      When Open site
      And go to new goods category
      Then choose products on page by 1 number
      Given add product in cart
      And go to cart
      And delete add product from cart
