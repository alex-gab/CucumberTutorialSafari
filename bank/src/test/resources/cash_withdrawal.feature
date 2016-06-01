Feature: Cash withdrawal
  Scenario: Successful withdrawal from an account in credit
    Given I have deposited $100.34 in my account
    When I request $20
    Then $20 should be dispensed
