@wip
Feature: favoritelist functionality

  Scenario: the user should add and delete favorite product to favorite list
    Given the user go to n11 url
    Then verify the user is on the homepage

    When the user login with valid credentials
    Then verify the user can login successfully

    When the user search "Iphone" keyword
    Then verify "Iphone" keyword is searched

    When the user go to 2. page
    Then verify the user is on the 2. page

    When the user add 3. product to favoritelist
    And the user go to "Favorilerim / Listelerim"
    Then verify the user is on the favoritelist
    When the user delete the product from the favoritelist
    Then verify the product is delete

    When the user click to "Çıkış Yap" button
    Then verify the user log out successfully


