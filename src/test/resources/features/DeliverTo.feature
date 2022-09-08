Feature: Test scenario for Amazon

  Scenario: Verify ZipCode update in Delivery to section
    Given User is on Main page
    When User enters zipcode "36104"
    Then Zipcode "36104" is present on "https://www.amazon.com/"

  Scenario: Verify List of countries contains Poland
    Given User is on Main page
    When User opens List of countries
    Then "Poland" is present in the List of countries

  Scenario: Verify Shipping To section contains Deliver To country
    Given User is on Main page
    When User chooses "Poland" in Delivery To section
    And User goes to Headsets Catalog and chooses Catalog item
    Then "Poland" is present in Shipping To section