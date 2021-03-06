package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    public WebDriver driver;

    @FindBy(css =".alert")
    private WebElement loginMessage;

    @FindBy(id="link-to-login")
    private WebElement linkToLogin;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickLoginButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("link-to-login")));
        linkToLogin.click();
    }

    public String getLoginMessage(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginMessage));
        return loginMessage.getText();
    }
}
