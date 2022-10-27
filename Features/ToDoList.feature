Feature: Vue To do list Scenarios

  Scenario: Create a list of items in To Do list and perform operations like mark completion , filter and deletion of items
    Given I am in todo mvc webpage
    When I enter the details in the textbox
      | Task 1 |
      | Task 2 |
      | Task 3 |
      | Task 4 |
    And I mark item as complete and verify filter count is correct
    Then clear the completed items
    And delete remaining items in the list
