package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Baseclass;

public class LoginPage {

	ExtentTest test= Baseclass.test;
	
//**************Web elements****************
    WebDriver driver = Baseclass.driver;
    
    @FindBy(linkText="Log in")
    WebElement LoginLink;
    
    @FindBy(name="user_login")
    WebElement UserName;
    
    @FindBy(id="password")
    WebElement Password;
    
    @FindBy(className="rememberMe")
    WebElement Remember;
    
    @FindBy(name="btn_login")
    WebElement LoginButton;
    
    @FindBy(id="msg_box")
    WebElement Error;

  public LoginPage() {
        
        PageFactory.initElements(driver, this);
    }
  
  //******************methods**************
  
    
    public void login(String Uname, String Pass)
    {
    
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(LoginLink));
            
        LoginLink.click();
        test.log(LogStatus.PASS, "Click on Login Link","Successfully clicked the link");
        
        UserName.sendKeys(Uname);
        test.log(LogStatus.PASS, "Enter Username"+Uname,"Successfully Entered the Name");
        
        
        Password.sendKeys(Pass);
        test.log(LogStatus.PASS, "Enter Password"+ Pass,"Successfully Entered the Password");
        
        
        Remember.click();
        
        LoginButton.click();
        test.log(LogStatus.PASS, "Click on Login Button","Successfully clicked the Button");
        
    }
    
    public void Errorcheck()
    {

        
        String Actualmsg = Error.getText();
        String Expmsg = "The email or password you have entered is invalid.";
        
//        Assert.assertEquals(Actualmsg, Expmsg); //Hard assert only include in TestNg method and to check actual output with expected output
    
        
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(Actualmsg, Expmsg);
        
        System.out.println("After Assertion");
        
        soft.assertAll();
    }

}