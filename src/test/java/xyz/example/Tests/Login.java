package xyz.example.Tests;

import data.ReadingFromExcel;
 import org.openqa.selenium.WebElement;
 import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;
import java.io.IOException;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginWithExcel extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @DataProvider(name="excelData")
    public Object[][] loginData() throws IOException {
        ReadingFromExcel readingFromExcel=new ReadingFromExcel();
        return readingFromExcel.getExcelData();

    }




    @Test
    public void loginWithValidData() throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        ReadingFromExcel readingFromExcel = new ReadingFromExcel();
        Object[][] excelData = readingFromExcel.getExcelData();
        String email = (String) excelData[0][0];
        String password = (String) excelData[0][1];
        loginPage.login(email, password);
        WebElement errorMessage = loginPage.loginErrorMessage;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertTrue(loginPage.background.isDisplayed());

    }

    @Test
    public void loginWithNotExistedMail() throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        ReadingFromExcel readingFromExcel = new ReadingFromExcel();
        Object[][] excelData = readingFromExcel.getExcelData();
        String email = (String) excelData[1][0];
        String password = (String) excelData[1][1];
        loginPage.login(email, password);
        WebElement errorMessage = loginPage.loginErrorMessage;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals(errorMessage.getText(), "Your credentials are not correct. Please check your email/password.");


    }

    @Test
    public void loginWithWrongPassword() throws InterruptedException, IOException {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

        ReadingFromExcel readingFromExcel = new ReadingFromExcel();
        Object[][] excelData = readingFromExcel.getExcelData();
        String email = (String) excelData[2][0];
        String password = (String) excelData[2][1];
        loginPage.login(email, password);
        WebElement errorMessage = loginPage.loginErrorMessage;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals(errorMessage.getText(), "Your credentials are not correct. Please check your email/password.");


    }

}
