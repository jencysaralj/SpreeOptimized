package Search;

import Pages.ProductListing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchSimilarItems {
    public WebDriver driver;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void similarItems(){
        String chromeDriverPath = System.getProperty("user.dir") + "/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='keywords']")).sendKeys("ruby");
        WebElement searchButton=driver.findElement(By.xpath("//*[@id='search-bar']/form/input[2]"));
        searchButton.click();
        ProductListing selectProduct = new ProductListing(driver);
        WebElement itemName= driver.findElement(By.xpath("//*[@id=\"product_4\"]/div/div[1]/a/span"));
        String item=itemName.getText();
        itemName.click();
        selectProduct.selectSimilarItems(item);

    }
}
