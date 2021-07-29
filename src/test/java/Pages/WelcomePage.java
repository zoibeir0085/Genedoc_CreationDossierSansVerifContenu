package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    @FindBy(how = How.LINK_TEXT, using="Nouveau dossier")
    public WebElement btnNouveauDossier;

    public WelcomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);

    }

    public void goToNouveauDossier(){
        btnNouveauDossier.click();

    }

}
