Feature: CRUD тесты для Milestones (с параметризацией)

  Background:
    Given browser is open



    Scenario: Add project
      Given login page opened user logged in
      And Add project page is opened
      When name project "AAA_SEA", announcement project "SEA_Announcement"
      Then message "Successfully added the new project." is displayed

    Scenario: Add milestone
      Given Add milestone page is opened
      When name milestone "SEA_Milestone", references milestone "SEA_References", description milestone "SEA_Description"
      Then message milestone "Successfully added the new milestone." is displayed

    Scenario: Update milestone
      Given Update milestone page is opened
      When update name milestone "Update_SEA_Milestone", references milestone "Update_SEA_References", description milestone "Update_SEA_Description"
      Then message update milestone "Successfully updated the milestone." is displayed

    Scenario: Delete milestone
      Given Milestone page is opened
      When delete milestone
      Then message delete milestone "Successfully deleted the milestone." is displayed