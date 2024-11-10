package xyz.example.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public void openUrl() {
        driver = new ChromeDriver();
        driver.get("https://vtwoproducttesting.naqla.systems");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }


    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
