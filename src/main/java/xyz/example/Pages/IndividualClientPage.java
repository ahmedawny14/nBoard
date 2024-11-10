package xyz.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndividualClientPage extends PageBase {

    public IndividualClientPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@type='button']")
    public WebElement newIndividualClientBtn;

    @FindBy(xpath = "//div[@class='col-md-6']//div[@class='form-group']//div//input[@placeholder='English Name']")
    WebElement nameEn;

    @FindBy(xpath = "//div[@class='col-md-6']//div[@class='form-group']//div//input[@placeholder='Arabic Name']")
    WebElement nameAr;

    @FindBy(xpath = "//div[@class='col-md-6']//div[@class='form-group']//div//input[@placeholder='Phone Number']")
    WebElement phoneNumber;

    @FindBy(xpath = "//input[@placeholder='Image']")
    WebElement image;

    @FindBy(xpath = "//input[@type='search']")
    WebElement status;

    @FindBy(xpath = "//li[@id='vs2__option-1']")
    WebElement active;

    @FindBy(xpath = "//li[@id='vs1__option-1']")
    WebElement suspended;

    @FindBy(xpath = "//button[@class='btn mb-0 btn-dark btn-md null null']")
    WebElement submitBtn;

    @FindBy(xpath = "//button[normalize-space()='Close']")
    WebElement close;

    @FindBy(xpath = "//td[normalize-space()='6672']")
    public WebElement clientId;

    @FindBy(xpath = "//div[normalize-space()='English Name Field is Required']")
    public WebElement nameEnError;

    @FindBy(xpath = "//div[normalize-space()='الحقل name ar مطلوب.']")
    public WebElement nameArError;

    @FindBy(xpath = "//div[normalize-space()='Phone Field is Required']")
    public WebElement phoneNumberError;

    @FindBy(xpath = "//div[normalize-space()='قيمة الحقل contact مُستخدمة من قبل']")
    public WebElement duplicatedPhoneNumber;

    public void createNewIndClient(String englishName, String arabicName, String phone_Number) throws InterruptedException {
        newIndividualClientBtn.click();
        nameEn.sendKeys(englishName);
        nameAr.sendKeys(arabicName);
        phoneNumber.sendKeys(phone_Number);
        submitBtn.click();
    }

    // Search elements and methods.
    @FindBy(xpath = "//input[@placeholder='ID']")
    public WebElement searchWithId;

    @FindBy(xpath = "//input[@placeholder='English Name']")
    public WebElement searchWithEnglishName;


    @FindBy(xpath = "//input[@placeholder='Arabic Name']")
    public WebElement searchWithArabicName;

    @FindBy(xpath = "//input[@placeholder='Phone Number']")
    public WebElement searchWithPhoneNumber;

    @FindBy(xpath = "//button[@class='btn mb-0 bg-gradient-main btn-md null null px-3']")
    public WebElement searchIcon;

    @FindBy(xpath = "//*[@id=\"app\"]/main/div/div[2]/div/div/div[2]/div[1]/table/tbody/tr/td[1]")
    public WebElement searchResult;


    public void searchWithIdMethod(String id) {
        searchWithId.sendKeys(id);
        searchIcon.click();
    }

    public void searchWithEnglishName(String nameEn)
    {
        searchWithEnglishName.sendKeys(nameEn);
        searchIcon.click();
    }

    public void searchWithArabicName(String nameAr){
        searchWithArabicName.sendKeys(nameAr);
        searchIcon.click();
    }

    public void searchWithPhoneNumber(String phone){
        searchWithPhoneNumber.sendKeys( phone);
        searchIcon.click();
    }

}

