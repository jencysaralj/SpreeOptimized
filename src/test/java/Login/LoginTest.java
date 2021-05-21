package Login;

import Pages.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {

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
    @Test
    public void LoginAndLogoutIntoSpree() throws Exception {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.loginAs("jency@gmail.com","jency123");
        Assert.assertEquals(login.getLoginMessage(),"Logged in successfully");
        Logout logout = new Logout(driver);
        logout.logoutMethod();
        Assert.assertEquals(logout.getLoginMessage(),"Signed out successfully.");
    }

    @Test
    public void invalidLoginIntoSpree() throws Exception {
        Login login = new Login(driver);
        login.clickLoginButton();
        login.loginAs("jency@gmail.com","jency1234");
        Assert.assertEquals(login.getLoginMessage(),"Invalid email or password.");
    }

}