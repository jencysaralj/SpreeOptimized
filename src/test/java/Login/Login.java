package Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Header{
    private WebDriver driver;
    @FindBy(id="spree_user_email")
    private WebElement userName;

    @FindBy(id="spree_user_password")
    private WebElement password;

    @FindBy(name="commit")
    private WebElement submit;

    public Login (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void loginAs(String email,String passwd){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.sendKeys(email);
        password.sendKeys(passwd);
        submit.click();
    }
}
