package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(how = How.ID, using="Username")
    public WebElement textUserName;

    @FindBy(how = How.ID, using="Password")
    public WebElement textPassword;

    @FindBy(how = How.ID, using="se-logger")
    public WebElement btnLogin;



    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void Login (String userName, String password){
        textUserName.sendKeys(userName);
        textPassword.sendKeys(password);
    }

    public void ClickLogin(){
        btnLogin.submit();
    }

}
