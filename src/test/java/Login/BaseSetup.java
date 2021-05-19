package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseSetup {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        String chromeDriverPath = System.getProperty("user.dir")+"/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
