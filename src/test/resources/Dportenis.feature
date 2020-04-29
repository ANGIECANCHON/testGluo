Feature:Login into the page dportenis mx

  @LoginError
  Scenario Outline: Login and manage o errors dportenis
    Given I login with the email <email> and password <password>
    Then The data is incorrect and show me an error message

    Examples:

    |email          | password    |
    |test@test.test | 1234567890  |

  @AddToCartError
  Scenario: Add products to cart without size
    Given I choose one product to add to my cart without add the size
    Then Do not add the producto and show me an error message that the size is missing

  @ShowProducts
  Scenario: Show products in the cart
    Given I choose one product to add to my cart with the size
    Then I see my prducts into the cart correctly