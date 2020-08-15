@all
@tsum_glass
  Feature: Search sunglasses in men product category
    Scenario: search sunglasses
      When Open site
      And change goods category by gender
      Given search good "Солнечные очки"
      Given click on gender "Мужское" filter
