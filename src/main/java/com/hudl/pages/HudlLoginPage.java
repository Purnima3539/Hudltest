package com.hudl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.hudl.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HudlLoginPage extends TestBase {

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="logIn")
    WebElement loginBtn;


    @FindBy(linkText="Need help?")
    WebElement needHelpLink;



    //Initializing the Page Objects:
    public HudlLoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void login(String em, String pwd){
        email.sendKeys(em);
        password.sendKeys(pwd);
        loginBtn.click();
    }

    public String getLoginErrorText(String em, String pwd){
        login(em,pwd);
        return needHelpLink.getText();
    }
    public HomePage validLogin(String em, String pwd){
        login(em,pwd);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.linkText(HomePage.exploreLinkText)));
        return new HomePage();
    }


}
