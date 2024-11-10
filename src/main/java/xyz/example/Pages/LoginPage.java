package xyz.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends  PageBase {

    public LoginPage(WebDriver driver)
    {

      super(driver);

    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField;

    @FindBy (xpath = "//input[@placeholder='Password']")
    WebElement passwordFiels;

    @FindBy(xpath = "//div[@class='text-center']")
     WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"app\"]/main/main/section/div/div/div/div[1]/div/div/div[2]/form/div[1]")
    public WebElement loginErrorMessage;

    public void login(String email,String password)
    {
        emailField.sendKeys(email);
        passwordFiels.sendKeys(password);
        signInButton.click();

    }
}
