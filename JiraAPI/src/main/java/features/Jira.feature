Feature: Creating a Jira issue using APIs

  Scenario:Create issue using Atlassian public APIs
    Given Prepare request specification for Jira API
    And Add body content in request specification
    When Make post http request call for the API
    Then Issue should be created successfully with 201 status code

    Scenario: Adding screenshot as attachment to the already created issue using API calls
      Given Get issue id from last scenario
      When Make post http request call to attach screenshot
      Then Attachment should be added successfully with 200 status code



