
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListing extends Header{
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='search-bar']/form/input[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='keywords']")
    private WebElement searchString;

    public ProductListing(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


     public void searchStringAndClickSearchButton(String item){
        searchString.sendKeys(item);
        searchButton.click();
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