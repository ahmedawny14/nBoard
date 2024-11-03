package xyz.example.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginWithDataProviders extends TestBase {




    LoginPage loginPage;
    HomePage homePage;
    @DataProvider(name = "login")
    public Object[][] loginData() {

        return new Object[][]

                {
                        {"ahmedcrm10@naqla.xyz","ahmed1234"},
                        {"ahmedops10@naqla.xyz","ahmed1234"}

                };
    }
    @Test(dataProvider = "login")
    public void loginWithValidData(String email, String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Thread.sleep(3000);
        //assertEquals(homePage.accountUserName.getText(), "Test_AHmedCRM");
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
