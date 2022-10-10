Feature: Verify Login ceredentials with Data
  Scenario Outline: Check Admin Login for Orange HRMS
    Given open browser with URL
    And Login page should be Visible
    When I pass Username as <username> Password as <password> and verify with Error message as <errormsg>
    Then CLick LOgin button

    Examples: 
      | username | password      | errormsg              |
      | "Admin"  | "Qedge123!@#" | ""                    |
      | "Admin"  | "abcd"        | "Invalid credentials" |
     	| "abcde"  | "Qedge123!@#" | "Invalid credentials" |
     	| "acdd"   | "a1233"       | "Invalid credentials" |