package xyz.example.Tests;

import data.ReadProperties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LoginWithFileProperties extends TestBase {




    LoginPage loginPage;
    HomePage homePage;
    ReadProperties properties=new ReadProperties();


    String myEmail= ReadProperties.userData.getProperty("email");
    String myPassword= ReadProperties.userData.getProperty("password");



    @Test()
    public void loginWithValidData( ) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myPassword);
        Thread.sleep(3000);
        assertEquals(homePage.accountUserName.getText(), "Test_AHmedCRM");
        homePage.signOut.click();

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
