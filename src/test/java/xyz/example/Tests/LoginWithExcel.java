package xyz.example.Tests;

import data.ReadingFromExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class LoginWithExcel extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @DataProvider(name="excelData")
    public Object[][] loginData() throws IOException {
        ReadingFromExcel readingFromExcel=new ReadingFromExcel();
        return readingFromExcel.getExcelData();

    }




    @Test(dataProvider = "excelData")
    public void loginWithValidData(String email,String password) throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        Thread.sleep(3000);
        loginPage.login(email, password);
        Thread.sleep(3000);
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
