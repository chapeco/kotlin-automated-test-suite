Feature: Foo

#  Scenario: Bar
#    When the user does the thing
#    Then the user should see the thing

  Scenario: Config Sanity Check
    When the config loads "input.search"
    Then the config string should equal "foo"