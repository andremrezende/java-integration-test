Feature: Checkout Resource

    Background:
        Given geracao de uuid "40e6215d-b5c6-4896-987c-f30f3678f608"

    Scenario: criar checkout
        When uma request no endpoint "/v1/checkout/"
        Then deve criar o checkout e retornar status code of 201
        And a resposta deve ser "{\"code\":\"c3ec1793-67b5-4291-e54svc1243\"}"
