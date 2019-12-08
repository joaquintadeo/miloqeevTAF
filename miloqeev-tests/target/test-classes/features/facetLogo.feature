@FacetTest
Feature: Facet logo validation
  Scenario: Facet logo should appear on Facet Web Page
    Given User opens a browser
    When User navigates to Facet Web Page
    Then User must see facet logo

  Scenario: Ingreso logo should appear on Facet Web Page
    Given User opens browser and goes to facet web page
    When User clicks on Ingreso button
    Then User must see ingreso logo
