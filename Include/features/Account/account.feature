@account @regression @sanity
Feature: As a login customer go to settings screen

  Background: 
    Given I am connected
      | email                     | password    |
      | comptesansfid@yopmail.com | Test@12345! |
    And I am in account screen

   @PL @LU @ROM @settings
  Scenario: Check settings link
    When I clicked the settings entry
    Then I am rediret to seetings app

  @ES  @PL @LU @ROM @country_swicth
  Scenario Outline: I can switch to another country
    When I switch to another "<country>"
    Then I see the entry lang  "<text>"

    Examples: 
      | country | text    |
      | PL      | Kraj    |
      | RO      | Tara    |
      | LU      | Langue  |
      | ES      | Idiomas |

   @PL @LU @ROM @cookies
  Scenario: Check cookies preferences
    When I clicked the cookies preferences entry
    Then I see cookies screen
