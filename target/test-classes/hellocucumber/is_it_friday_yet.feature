Feature: Is it Friday yet?
  Everyone wants to know when it's Friday

  Scenario:
    Given Today is Sunday
    When I ask when when it's Friday yet
    Then I should be told "Nope"