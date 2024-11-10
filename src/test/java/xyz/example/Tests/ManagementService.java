package xyz.example.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;
import xyz.example.Pages.ManagementServicePage;

public class ManagementService extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ManagementServicePage managementServicePage;




    @Test
    public void createManageServiceWithValidData() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);

        managementServicePage = new ManagementServicePage(driver);
        managementServicePage.createManagementService("Technology Test", "300", "500", "200");
        Thread.sleep(3000);
        Assert.assertEquals(managementServicePage.ManagementJobsList.getText(), "MANAGEMENT JOBS LIST");

    }

    @Test
    public void createManageServiceWithoutClientName() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);

        managementServicePage = new ManagementServicePage(driver);
        managementServicePage.createManagementService("", "300", "500", "200");
        Thread.sleep(3000);
        String expectedErrorMessge = "Client Field is Required";
        String actualErrorMessage = managementServicePage.noClientErrorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessge);

    }

    @Test
    public void createManageServiceWithoutCost() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);

        managementServicePage = new ManagementServicePage(driver);
        managementServicePage.createManagementService("Technology Test", "", "500", "200");
        Thread.sleep(3000);
        String expectedErrorMessge = "Truck Tariff Value Must Be Integer";
        String actualErrorMessage = managementServicePage.noCostMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessge);

    }

    @Test
    public void createManageServiceWithoutSelling() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);

        managementServicePage = new ManagementServicePage(driver);
        managementServicePage.createManagementService("Technology Test", "300", "", "200");
        Thread.sleep(3000);
        String expectedErrorMessge = "Selling Field is Required";
        String actualErrorMessage = managementServicePage.noSellingMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessge);
    }


    @Test
    public void createManageServiceWithoutOpsExpanses() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);

        managementServicePage = new ManagementServicePage(driver);
        managementServicePage.createManagementService("Technology Test", "300", "500", "");
        Thread.sleep(3000);
        String expectedErrorMessge = "Ops Expenses Value Must Be Integer";
        String actualErrorMessage = managementServicePage.noOpsExpansesMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessge);
    }


    @Test
    public void searchForANOrder() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        managementServicePage = new ManagementServicePage(driver);

        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");

        homePage.clickManagementServiceButton();
        Thread.sleep(3000);
        managementServicePage.searchForAnOrderFunction("MS24100026-1");
        Thread.sleep(3000);

        Assert.assertTrue(managementServicePage.searchedCode.getText().contains("MS24100026-1"));
    }


}
