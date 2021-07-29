Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario Outline: NO EIP dependency
    Given I navigate to the login page
    And I enter "<username>" and "<password>"
    And I click login button
    #Then I should see the welcome page
    Then I navigate to the creation of new folder page
    Then I enter "<Document>"  , "<CharteGraphique>", "<Rédacteurs>" and "<Approbateur>"
    Then I validate the form1
    Then I verify the no EIP
    Then I validate
    Then I preview
    #Then I verify that the pdf was successfully downloaded
    #Then I verify the contenu of the pdf non EIP
    #Then I logout
    Then I close the browser
    Examples:
      | username        | password | Document                            | CharteGraphique       | Rédacteurs     | Approbateur    |
      | rgauvin@kpmg.fr | aezan75  |  CAC\Rapport sur les comptes annuels V3 -- (Modèle version 1.0) |  Rapport CAC  | BELKACEM Amine | BELKACEM Amine |




  #Scenario Outline: EIP dependency
    #Given I navigate to the login page
    #And I enter "<username>" and "<password>"
    #And I click login button
    #Then I navigate to the creation of new folder page
    #Then I enter "<Document>"  , "<CharteGraphique>", "<Rédacteurs>" and "<Approbateur>"
    #Then I activate EIP
    #Then I validate the form2
    #Then I verify the EIP
    #Then I validate
    #Then I preview
    #Then I verify that the pdf was successfully downloaded
    #Then I verify the contenu of the pdf EIP
    #Then I logout
    #Then I close the browser
    #Examples:
     #| username        | password | Document                            | CharteGraphique       | Rédacteurs     | Approbateur    |
      #| rgauvin@kpmg.fr | aezan75  | CAC\Rapport sur les comptes annuels V3 -- (Modèle version 1.0)  |  Rapport CAC  | BELKACEM Amine | BELKACEM Amine |
