Feature: CRUD тесты для Milestones (с параметризацией)

  Background:
    Given browser is open
    And login page opened user logged in


    Scenario: Add project
      Given Add project page is opened
      When name project "AAA_SEA", announcement project "SEA_Announcement"
      Then message "Successfully added the new project." is displayed