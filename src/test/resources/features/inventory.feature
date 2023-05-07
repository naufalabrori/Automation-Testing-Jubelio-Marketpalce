@All
  Feature: Manage stock items in jubelio marketplace

    @AddStock
    Scenario: User add stocks inventory
      Given User in jubelio homepage
      When User select inventory menu
      And User select inventory adjustment
      And User select item to be adjusted
      Then User save inventory adjustment