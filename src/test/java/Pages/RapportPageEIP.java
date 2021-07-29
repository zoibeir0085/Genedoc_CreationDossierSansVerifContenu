package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static org.junit.Assert.assertThat;

import java.util.List;

public class RapportPageEIP 
{
    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[2]/img[2]")
    public WebElement btnValidation;

   // @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]")
    public WebElement btnPreview;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[3]/ol/li[2]/ol/li[2]/ol/li/div")
    public WebElement articleNoEIP;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[3]/ol/li[3]/ol/li[2]/ol/li/div")
    public WebElement articleEIP;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/textarea")
    public WebElement articleReference;



    @FindBy(how = How.LINK_TEXT, using="Se dÃ©connecter")
    public WebElement btnLogout;

    public RapportPageEIP(WebDriver driver)  
    {
        PageFactory.initElements(driver,this);
        
        btnValidation=driver.findElement(By.id("progressbar")).findElement(By.xpath("img[2]")); 
        
        
    }

    public void Validate() 
    {
    	
        btnValidation.click();
    }

    public void Preview(WebDriver driver) throws InterruptedException 
    {
        Thread.sleep(5000);
        btnPreview=driver.findElement(By.id("previewValidate")); 
        btnPreview.click();
    }


    public void verifyEIP(WebDriver driver) throws InterruptedException{
       /* Thread.sleep(3000);
        articleEIP.click();
        Thread.sleep(3000);
        System.out.println("article reference= "+articleReference.getText());
        boolean EIP=(articleReference.getText().equals("IndÃ©pendance EIP"));
        Thread.sleep(3000);
        //Assert.assertEquals(EIP,true,"its not displayed" );
        Thread.sleep(3000);*/
        
        
        Thread.sleep(3000);
        
        List<WebElement> lstarticles=driver.findElements(By.className("article"));
         
        for (WebElement art : lstarticles) 
        {
        	if(art.getText().equals("Indépendance EIP"))
        	{
        		 articleEIP=art;
        		 articleEIP.click();
        		 
        		 articleReference=driver.findElement(By.id("idtitles")); 
        		 WebElement articleTitre=driver.findElement(By.id("idtitles2")); 
          	     articleTitre.sendKeys("Indépendance EIP");
          	     Thread.sleep(3000);
        	}
		}


    }

    public void Logout(){
        btnLogout.click();
    }

}
