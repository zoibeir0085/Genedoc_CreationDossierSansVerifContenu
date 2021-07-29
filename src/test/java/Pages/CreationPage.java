package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;

public class CreationPage {
    @FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]/div/div/a")
    public WebElement btnValidation2;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/form/section/div/div/a")
    public WebElement btnValidation3;


    @FindBy(how = How.ID, using = "validbutton")
    public WebElement btnValidation;

    //@FindBy(how = How.XPATH, using = "/html/body/div[4]/form/div/table/tbody/tr[65]/td[2]/div/div/div")
    public WebElement eip;



    public CreationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void SelectDocument(WebDriver driver,String document){
        Select SelectedDoc=new Select(driver.findElement(By.id("SelectDocument"))) ;
        SelectedDoc.selectByVisibleText(document);
    }

    public void SelectChart(WebDriver driver,String chart){
        Select SelectedChart=new Select(driver.findElement(By.id("SelectChart"))) ;
        SelectedChart.selectByVisibleText(chart);
    }

    public void SelectRedactors(WebDriver driver,String redactor){
        Select SelectedRedactors=new Select(driver.findElement(By.id("SelectRedactors"))) ;
        SelectedRedactors.selectByVisibleText(redactor);
        SelectedRedactors.selectByVisibleText("Corbet Sophie");

    }

    public void SelectApprobator(WebDriver driver,String approbator){
        Select SelectedApprobator=new Select(driver.findElement(By.id("SelectApprobator"))) ;
        SelectedApprobator.selectByVisibleText(approbator);
    }


    public void activateEIP(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        
        List<WebElement> LstQuestionVariables=driver.findElement(By.id("scaling_questionq_ldm")).findElements(By.xpath("tbody/tr"));
        for (WebElement qv : LstQuestionVariables) 
        {
        	//Est-ce une Entité d'Intérêt Public?
        	if(qv.getText().contains("Est-ce une Entité d'Intérêt Public?"))
        	{
        		//td[2]/div/div/div"
        		System.out.println("article eip = " + qv.getText());
        		eip=qv.findElement(By.xpath("td[2]/div/div/div"));
        		eip.click();
                Thread.sleep(8000);
        	}
        }
        
    }


    public void Validate() {
        btnValidation.click();
    }


    public void Validate2() throws InterruptedException {
        btnValidation2.click();
        Thread.sleep(5000);
    }

    public void Validate3(WebDriver driver) 
    {
    	btnValidation3=driver.findElement(By.name("btn_UpdateVariables"));
    	
        btnValidation3.click();
    }

}