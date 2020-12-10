Feature:To create and validate a new user created in E-learn application 

Scenario Outline: Register in elearn and validate 
To register a new user and verify
    Given I launch elearn application url
    When In Home page
    Then Sign in to Register
    And Enter registration details using "<firstname>","<lastname>","<email>","<uname>","<pass>","<conf_pass>"
    Then click register
    And verify the user is registered
    Examples:
    | firstname    | lastname   | email                       | uname       | pass          |  conf_pass      |
    | Jakes        | Johns      | jake125.john@gmail.com      | jake22      |	v1dya@01      |	v1dya@01        |
    
    
Scenario Outline: Send mail and validate message is sent 
    Given Click on homePage
    When In homepage
    Then Click on Compose
    And enter "reciever" mail id , "subject" and "message"
    Then click send button
    And Verify acknowledgement shown
    Examples:
      | reciever   | subject   | Message            |
      | naveen     | hi        | sample mail        | 
   