Feature: Более сложный тест с вынесением в Background повторяющихся действий

  Background:
    Given открыт браузер
    And страница логина открыта

  Scenario: Использование AND в Given
      Given user logged in

  Scenario: Простой тест со всеми ключевыми словами
       Then username field is displayed