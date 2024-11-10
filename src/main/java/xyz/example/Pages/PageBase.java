package xyz.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected static WebDriver driver;

    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



}


