@all
@tsum_mennew
  Feature: Check new products for men

    Scenario: Check new products for men
      When Open site
      And change goods category by gender
      Given go to new goods category
      Given click on show more product

      When set other filter "Big sizes"
      Given select product name "Хлопковые брюки" and product number 1 on page
      And chose color on rgb: "0", "0", "0"
      Then select size "IT 54 | RU 54" for product

      When click fast buy product
      Given insert client name "ojhfoi" and client phone "71111111111"