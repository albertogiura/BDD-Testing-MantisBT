Feature: Search an issue

  Background:
    Given a logged in user

  Scenario: Look for the latest reported issue
    Given an existing project named "test"
    When the user reaches the issues page
    And picks the most recent bug
    Then the bug detail page for that issue is displayed

  @internal
  Scenario: Found a previously reported issue
    Given an existing project named "test"
    When I look for a bug with ID "0000003"
    Then the bug detail page for issue "0000003" is displayed