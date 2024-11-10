package xyz.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementServicePage extends PageBase{

    public static  HomePage homePage;

    public ManagementServicePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(className = "table-new-btn")
    WebElement newRequestBtn;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
    WebElement clientField;

    @FindBy(xpath = "//body/div[@id='app']/main[@class='main-content position-relative max-height-vh-100 h-100 border-radius-lg']/div[@class='container-fluid']/div[@class='row']/div[@class='col-12']/div[@class='multisteps-form']/div[@class='row']/div[@class='col-lg-12']/form/div[@class='bg-white']/div[@class='p-3 bg-white card multisteps-form__panel border-radius-xl js-active position-relative']/div[@class='multisteps-form__content mb-3']/div[@class='row']/div[2]/div[1]/div[1]/input[1]")
    WebElement managementFeesCost;

    @FindBy(xpath = "//body/div[@id='app']/main[@class='main-content position-relative max-height-vh-100 h-100 border-radius-lg']/div[@class='container-fluid']/div[@class='row']/div[@class='col-12']/div[@class='multisteps-form']/div[@class='row']/div[@class='col-lg-12']/form/div[@class='bg-white']/div[@class='p-3 bg-white card multisteps-form__panel border-radius-xl js-active position-relative']/div[@class='multisteps-form__content mb-3']/div[@class='row']/div[3]/div[1]/div[1]/input[1]")
    WebElement managementFeesSelling;

    @FindBy(xpath = "//main[@class='main-content position-relative max-height-vh-100 h-100 border-radius-lg']//span[2]")
    WebElement selectClient;


    @FindBy(xpath = "//input[@placeholder='Gate']")
    WebElement gateField;

    @FindBy(xpath = "//li[@id='vs3__option-1']")
    WebElement selectGate;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/div/form/div/div/div/div[1]/div[4]/div/div[3]/div/div/input")
    WebElement timeField;

    @FindBy(xpath = "//div[normalize-space()='31']")
    WebElement selectDay;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div/div[1]/ul/li[4]")
    WebElement selectHour;

    @FindBy(xpath = "//div[@class='input-group']//input[@placeholder='Example: 1']")
    WebElement opsExpansesField;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//li[@class='text-sm breadcrumb-item active text-white']")
    public WebElement ManagementJobsList;

    @FindBy (xpath="//*[@id=\"app\"]/main/div/div/div/div/div/div/form/div/div[1]/div/div/div/div")
    public WebElement noClientErrorMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div/div/form/div/div[1]/div/div/div/div")
    public WebElement noCostMessage;


    @FindBy(xpath="//*[@id=\"app\"]/main/div/div/div/div/div/div/form/div/div[1]/div/div/div/div")
    public WebElement noSellingMessage;

    @FindBy(xpath = "//div[@class='col-md-6 text-white']")
    public WebElement noOpsExpansesMessage;

    @FindBy(xpath = "//input[@placeholder='Job / Order Code']")
    WebElement searchForAnOrder;

    @FindBy(xpath = "//button[@class='btn mb-0 bg-gradient-main btn-md null null px-3']")
    WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div/div/div/div[2]/div[2]/div/div[1]/table/tbody/tr/td[1]")
     public WebElement searchedCode;














    public void createManagementService(String clientName,String managementCost,String SellingCost,String opsExpanses) throws InterruptedException {

        newRequestBtn.click();
        Thread.sleep(3000);
        clientField.sendKeys(clientName);
        selectClient.click();
        managementFeesCost.sendKeys(managementCost);
        managementFeesSelling.sendKeys(SellingCost);
        gateField.click();
        selectGate.click();
        timeField.click();
        Thread.sleep(3000);
        selectDay.click();
        selectHour.click();
        opsExpansesField.sendKeys(opsExpanses);
        submitButton.click();
    }


    public void searchForAnOrderFunction(String orderCode)
    {
        searchForAnOrder.sendKeys(orderCode);
        searchIcon.click();

    }


}
