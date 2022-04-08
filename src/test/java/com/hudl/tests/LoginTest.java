package com.hudl.tests;
import com.hudl.base.TestBase;
import com.hudl.pages.HudlLoginPage;
import com.hudl.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/*
I have covered few scenarios as part of this test.
Some other scenarios on Login page are
Functional tests: Remember Me checkbox, Need help link,Signup option, back icon to Hudl page, logging in with inactive credentials.
Security(Non-functional) tests: Verifying password encryption, password copy/paste, login page vulnerability to SQL injection
 */

public class LoginTest extends TestBase{
    HudlLoginPage loginPage;
    HomePage homePage;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new HudlLoginPage();
    }


    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.getLoginPageTitle();
        Assert.assertEquals(title, "Log In - Hudl");
    }


    @Test(priority=2)
    public void validLoginTest() throws  InterruptedException{
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        homePage = loginPage.validLogin(email,password);
        String homePageTitle = homePage.getHomePageTitle();
        Assert.assertEquals(homePageTitle, "Home - Hudl");
    }

    @Test(priority=3)
    public void InvalidEmailTest() throws  InterruptedException{
        String email = prop.getProperty("invalidemail");
        String password = prop.getProperty("password");
        Assert.assertEquals( loginPage.getLoginErrorText(email,password), "Need help?");
    }

    @Test(priority=4)
    public void InvalidPasswordTest() throws  InterruptedException{
        String email = prop.getProperty("email");
        String password = prop.getProperty("invalidpassword");
        Assert.assertEquals( loginPage.getLoginErrorText(email,password), "Need help?");
    }
    @Test(priority=5)
    public void blankEmailPasswordTest() throws  InterruptedException {
        String email = prop.getProperty("blankemail");
        String password = prop.getProperty("blankpassword");
        Assert.assertEquals(loginPage.getLoginErrorText(email, password), "Need help?");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
