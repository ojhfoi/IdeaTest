@all
@tsum_accessory
  Feature: Check accessory product
    Scenario: Check accessory product category
      Given Open site
      And go to accessory category
      Then select scarf category of accessory product
      When set filter "Цвета" active
      Then select color "Фиолетовый" in filter
      And set filter "Бренд" active
      Then set brand filter by brand "Gucci"
      Then set other filter "Осень-зима 20/21"
      Given select product name "Шерстяной шарф" and product number 1 on page
      And select color "Серый" in combobox


      # Wow, it seem this test is capture bug's. For filter in this test available in other filter "Осень-зима 20/21".
      # But if we change value on "Осень-зима 19/20", we get full list of product, without filtration.
      # It seem like if not product in this filter, site show all product, without any alert message.