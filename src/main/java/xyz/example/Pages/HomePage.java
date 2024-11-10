package xyz.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/jobs/management/list?list-type=jobs&quick-link=toDoList']")
    WebElement managementServiceButton;

    public void clickManagementServiceButton() {
        managementServiceButton.click();
    }


    @FindBy(xpath = "//li[@class='ps-3 nav-item d-flex align-items-center text-white username']")
    public WebElement accountUserName;


    @FindBy(xpath = "//i[@class='cursor-pointer fas fa-sign-out-alt']")
    public WebElement signOut;

    @FindBy(xpath = "//body/div[@id='app']/aside[@id='sidenav-main']/div[@id='sidenav-collapse-main']/ul[@class='navbar-nav']/div[1]/li[1]/div[1]/a[1]")
   public  WebElement clientsModule;

    @FindBy(xpath = "//a[@href='/clients/individuals/list']")
    public WebElement individualClient;
}



