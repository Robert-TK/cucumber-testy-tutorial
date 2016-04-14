@screen
Feature: Customer I can login to web site

  Scenario: Successfully login
    Given I open url "https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html"
    When I login with "eu@fast.comx"/"eu.pass" on app
    Then I click on link with text "Logout"