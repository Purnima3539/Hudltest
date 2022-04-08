package com.hudl.pages;

import com.hudl.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(linkText="Explore")
    WebElement exploreLink;

    public  static  String exploreLinkText = "Explore";

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle(){
        return driver.getTitle();
    }
}
