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

public class RapportPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[2]/img[2]")
    public WebElement btnValidation;

    @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[2]/div[2]/span[1]")
    public WebElement btnPreview;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[3]/ol/li[2]/ol/li[2]/ol/li/div")
    public WebElement articleNoEIP;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[1]/div[3]/ol/li[3]/ol/li[2]/ol/li/div")
    public WebElement articleEIP;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[2]/textarea")
    public WebElement articleReference;



    @FindBy(how = How.LINK_TEXT, using="Se déconnecter")
    public WebElement btnLogout;

    public RapportPage(WebDriver driver)  
    {
        PageFactory.initElements(driver,this);
    }

    public void Validate() 
    {
        btnValidation.click();
    }

    public void Preview() throws InterruptedException 
    {
        Thread.sleep(5000);
        btnPreview.click();
    }

    public void verifyNoEIP(WebDriver driver) throws InterruptedException
    {
        Thread.sleep(3000);
        
        List<WebElement> lstarticles=driver.findElements(By.className("article"));
         
        for (WebElement art : lstarticles) 
        {
        	if(art.getText().equals("Indépendance non EIP"))
        	{
        		 articleNoEIP=art;
        		 articleNoEIP.click();
        		 
        		 articleReference=driver.findElements(By.className("droppableInput")).get(0); 
        		 
        	     //articleNoEIP.click();
        	      Thread.sleep(3000);
        	      System.out.println("article reference= "+articleReference.getText());
        	      boolean EIP=(articleReference.getText().equals("Indépendance non EIP"));

        	      //Assert.assertEquals(EIP,true,"its not displayed" );
        	      Thread.sleep(3000);
        	}
		}
        


    }

    public void verifyEIP(WebDriver driver) throws InterruptedException{
       /* Thread.sleep(3000);
        articleEIP.click();
        Thread.sleep(3000);
        System.out.println("article reference= "+articleReference.getText());
        boolean EIP=(articleReference.getText().equals("Indépendance EIP"));
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
        		 
        		 articleReference=driver.findElements(By.className("droppableInput")).get(0); 
        		 
        	     //articleNoEIP.click();
        	      Thread.sleep(3000);
        	      System.out.println("article reference= "+articleReference.getText());
        	      boolean EIP=(articleReference.getText().equals("Indépendance EIP"));

        	      //Assert.assertEquals(EIP,true,"its not displayed" );
        	      Thread.sleep(3000);
        	}
		}


    }

    public void Logout(){
        btnLogout.click();
    }

}
