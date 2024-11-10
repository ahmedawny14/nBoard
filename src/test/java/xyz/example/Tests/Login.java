package xyz.example.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Login extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void loginWithValidData() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");
        assertEquals(homePage.accountUserName.getText(), "Test_AHmedCRM");
    }

    @Test
    public void loginWithNotExistedMail() throws InterruptedException {


         homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("ahmed1234@naqla.xyz", "ahmed1234");
        assertEquals(loginPage.loginErrorMessage.getText(), "Your credentials are not correct. Please check your email/password.");

    }

    @Test
    public void loginWithWrongPassword() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed121314");
        Thread.sleep(3000);
        assertEquals(loginPage.loginErrorMessage.getText(), "Your credentials are not correct. Please check your email/password.");

    }

}
