package xyz.example.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import xyz.example.Pages.IndividualClientPage;
import xyz.example.Pages.HomePage;
import xyz.example.Pages.LoginPage;



import static org.testng.Assert.assertEquals;

public class IndividualClient extends TestBase {
    IndividualClientPage createIndividualClientPage;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void navigateToIndividualClient() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        createIndividualClientPage = new IndividualClientPage(driver);
        loginPage.login("ahmedcrm10@naqla.xyz", "ahmed1234");
        homePage.clientsModule.click();
        homePage.individualClient.click();

    }

    @Test
    public void createNewClientWithValidData() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.createNewIndClient("Ahmed Test12", "احمد تيست 12", "01005400232");
        String expectedResult = "English Name Field is Required";
        String actualResult = createIndividualClientPage.nameEnError.getText();
        assertEquals(actualResult, expectedResult);
    }


    @Test
    public void createNewClientWithoutEnglishName() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.createNewIndClient("", "احمد تيست 12", "01005400232");
        String expectedResult = "English Name Field is Required";
        String actualResult = createIndividualClientPage.nameEnError.getText();
        assertEquals(actualResult, expectedResult);
    }


    @Test
    public void createNewClientWithoutArabicName() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.createNewIndClient("Ahmed Tes14", "", "01005400232");
        String expectedResult = "الحقل name ar مطلوب.";
        String actualResult = createIndividualClientPage.nameArError.getText();
        System.out.println(actualResult);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void createNewClientWithoutPhoneNumber() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.createNewIndClient("Ahmed Tes14", "احمد تيست 14", "");
        String expectedResult = "Phone Field is Required";
        String actualResult = createIndividualClientPage.phoneNumberError.getText();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void createNewClientWithDuplicatedPhoneNumber() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.createNewIndClient("Ahmed Tes14", "احمد تيست 14", "01005400232");
        String expectedResult = "قيمة الحقل contact مُستخدمة من قبل";
        String actualResult = createIndividualClientPage.duplicatedPhoneNumber.getText();
        System.out.println(actualResult);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void searchWithId() throws InterruptedException {
         createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.searchWithIdMethod("6666");
        Thread.sleep(3000);
        assertEquals(createIndividualClientPage.searchResult.getText(),"6666");
    }


    @Test
    public void searchWithEnglishName() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.searchWithEnglishName("Mostafa Sophy");
        Thread.sleep(3000);
        assertEquals(createIndividualClientPage.searchResult.getText(),"6665");
    }
    @Test
    public void searchWithArabicName() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.searchWithArabicName("ميدو");
        Thread.sleep(3000);
        assertEquals(createIndividualClientPage.searchResult.getText(),"6660");
    }


    @Test
    public void searchWithPhoneNumber() throws InterruptedException {
        createIndividualClientPage = new IndividualClientPage(driver);
        createIndividualClientPage.searchWithPhoneNumber("01002857901");
        Thread.sleep(3000);
        assertEquals(createIndividualClientPage.searchResult.getText(),"6664");
    }


}
