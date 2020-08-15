@all
@tsum_bag

  Feature: Test 2. Check bag products

    Scenario: Check bag products
      Given Open site
      When go to bag category
      And set exclusive filter
      And sort good by "по возрастанию цены"
      Then choose products on page by 5 number
      And Watch products photo on gallery