@OB4
Feature: Purchase Foreign Currency
  @OB4AC1 @how
  Scenario: Available currencies
    Given the user accesses the Purchase foreign currency cash tab
     Then following currencies should be available
      |Australia (dollar)   |
      |Canada (dollar)      |
      |Switzerland (franc)  |
      |China (yuan)         |
      |Denmark (krone)      |
      |Eurozone (euro)      |
      |Great Britain (pound)|
      |Japan (yen)          |
      |Mexico (peso)        |
      |Norway (krone)       |
      |New Zealand (dollar) |
      |Singapore (dollar)   |
  @OB4AC2
  Scenario: Error message for not selecting currency
    Given the user accesses the Purchase foreign currency cash tab
     When user tries to calculate cost without selecting a currency
     Then error message should be displayed
  @OB4AC3
  Scenario: Error message for not entering value
    Given the user accesses the Purchase foreign currency cash tab
     When user tries to calculate cost without entering a value
     Then error message should be displayed