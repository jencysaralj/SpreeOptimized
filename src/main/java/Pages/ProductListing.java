
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListing extends Header{
    private WebDriver driver;
    public ProductListing(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void selectSimilarItems(String itemName){
        List<WebElement> similarItemList= driver.findElements(By.className("list-group-item"));
        for(WebElement sItem: similarItemList){
            if(sItem.getText().equalsIgnoreCase(itemName)){
                sItem.click();
            }
        }
    }
}