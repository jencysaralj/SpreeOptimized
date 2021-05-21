package Search;
import Pages.ProductListing;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchSimilarItems  {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        String chromeDriverPath = System.getProperty("user.dir")+"/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void similarItems(){
        ProductListing selectProduct = new ProductListing(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        selectProduct.searchStringAndClickSearchButton("ruby");
        WebElement itemName= driver.findElement(By.xpath("//*[@id=\"product_4\"]/div/div[1]/a/span"));
        String item=itemName.getText();
        itemName.click();
        selectProduct.selectSimilarItems(item);

    }
}
