package Steps;

//import cucumber.api.DataTable;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;


import Pages.* ;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import cucumber.api.DataTable;


public class FirstStep {
    WebDriver driver;



    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() {
        System.out.println("Navigate login page");
        //for windows
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //for linux
        //System.setProperty("webdriver.chrome.driver","chromedriver");


        Map<String, Object> prefs = new HashMap<String, Object>();

        //To Turns off multiple download warning
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver =  new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.navigate().to("https://aezan.genedoc.fr/Login");

    }



    @And("I click login button")
    public void iClickLoginButton() {
       // System.out.println("Click login button");

        LoginPageEIP page = new LoginPageEIP(driver);

        page.ClickLogin();
    }

    @Then("I should see the welcome page")
    public void iShouldSeeTheUserformPage() 
    {
        System.out.println("I should see userform");
        //Assert.assertEquals("its not displayed",driver.findElement(By.className("container body-content")).isDisplayed(),true );
        //driver.findElement(By.name("generate")).click() ;
    }

    @And("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUsernameAndPassword(String username, String password) throws InterruptedException {
        LoginPageEIP page = new LoginPageEIP(driver);
        page.Login(username,password);
        Thread.sleep(2000);
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() throws InterruptedException {
        Thread.sleep(1);
        driver.quit();
        driver=null ;
    }

    @Then("I navigate to the creation of new folder page")
    public void iNavigateToTheCreationOfNewFolderPage() throws InterruptedException {
        WelcomePageEIP page =new WelcomePageEIP(driver);
        page.goToNouveauDossier();
        Thread.sleep(2000);

    }
    
    @Then("I enter \"([^\"]*)\"  , \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"")
    public void iEnterAnd(String Document, String CharteGraphique, String Redacteurs, String Approbateur) throws InterruptedException {
        CreationPageEIP page = new CreationPageEIP(driver);

        //select DocumentType
        page.SelectDocument(driver,Document);

        //select CharteGraphique
        page.SelectChart(driver,CharteGraphique);

        //select Redactors
        page.SelectRedactors(driver,Redacteurs);

        //select Approbator
        page.SelectApprobator(driver,Approbateur);

        //Validation
        page.Validate();        Thread.sleep(3000);

    }

    @Then("I validate")
    public void iValidate() throws InterruptedException {
        RapportPageEIP page = new RapportPageEIP(driver);
        page.Validate();
        Thread.sleep(3000);

    }

    @Then("I preview")
    public void iPreview() throws InterruptedException {
        RapportPageEIP page = new RapportPageEIP(driver);
        page.Preview(driver);
        Thread.sleep(3000);

    }

    @Then("I logout")
    public void iLogout() throws InterruptedException {
        RapportPageEIP page = new RapportPageEIP(driver);
        page.Logout();
        Thread.sleep(3000);

    }
    @Then("I verify that the pdf was successfully downloaded")
    public void iVerifyThatThePdfWasSuccessfullyDownloaded() throws InterruptedException {
        DownloadsPageEIP page= new DownloadsPageEIP(driver);
        page.verifyDownloadWithFileExtension(".pdf");

    }


    @Then("I verify the EIP")
    public void iVerifyTheEIP() throws InterruptedException {
        RapportPageEIP page = new RapportPageEIP(driver);
        page.verifyEIP(driver);
    }

    @Then("I activate EIP")
    public void iActivateEIP() throws InterruptedException {
        CreationPageEIP page = new CreationPageEIP(driver);
        page.activateEIP(driver);


    }

    @Then("I validate the form1")
    public void iValidateTheForm1() throws InterruptedException {
        CreationPageEIP page = new CreationPageEIP(driver);
        page.Validate2();
        Thread.sleep(3000);

    }

    @Then("I validate the form2")
    public void iValidateTheForm2() throws InterruptedException {
        CreationPageEIP page = new CreationPageEIP(driver);
        page.Validate3(driver);
        Thread.sleep(3000);

    }

    @Then("I verify the contenu of the pdf EIP")
    public void iVerifyTheContenuOfThePdfEIP() {
        String cont1=new String("Ind");
        String cont4=new String("pendance");
        String cont2=new String("avons pas \n" +
                "fourni de services interdits l");
        String cont3="article 5, paragraphe 1,";
        String cont5="537/2014";
        PDFPageEIP page= new PDFPageEIP(driver);
        page.afficherPDF();
        boolean b1= page.verifyPDFContenu(cont1);
        Assert.assertTrue(b1, "Can not found : \n" +cont1);
        boolean b2= page.verifyPDFContenu(cont2);
        Assert.assertTrue(b2, "Can not found : \n" +cont2);
        boolean b3= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b3, "Can not found : \n" +cont3);
        boolean b4= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b4, "Can not found : \n" +cont4);
        boolean b5= page.verifyPDFContenu(cont3);
        Assert.assertTrue(b5, "Can not found : \n" +cont5);

    }


}
