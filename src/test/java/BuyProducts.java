import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import java.util.*;

public class BuyProducts {

    public WebDriver driver;

    private static By txtUserName = By.id("user-name");
    private static By txtPassword = By.id("password");
    private static By btnLogin = By.id("login-button");
    private static By btnAddFirstProduct = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
    private static By btnAddSecondProduct = By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button");
    private static By btnCart = By.id("shopping_cart_container");
    private static By btnCheckout = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]");
    private static By txtFirstName = By.id("first-name");
    private static By txtLastName = By.id("last-name");
    private static By txtZipCode = By.id("postal-code");
    private static By btnContinue = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input");
    private static By btnFinish = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]");


        @After
        public void tearDownAfterTest() {
           driver.close();
        }


        @Before
        public void setupBeforeTest() throws InterruptedException {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.get("https://www.saucedemo.com/");

            System.out.println(System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            driver.manage().window().maximize();

            String expectedTitle = "Swag Labs";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle,expectedTitle);


        }
    @Test

                public void AddToCart() throws InterruptedException{

            WebElement body = driver.findElement(By.tagName("body"));
            String bodyText = body.getText();

                    driver.findElement(txtUserName).sendKeys("standard_user");
                    driver.findElement(txtPassword).sendKeys("secret_sauce");
                    driver.findElement(btnLogin).click();
            //Assert.assertTrue("Does not contain the text 'Sauce Labs Backpack'", bodyText.contains("Sauce Labs Backpack"));
           // Assert.assertTrue("Does not contain the text 'Sauce Labs Bolt T-Shirt'", bodyText.contains("Sauce Labs Bolt T-Shirt"));
            //Assert.assertTrue("Does not contain the text 'Sauce Labs Bolt Fleece Jacket'", bodyText.contains("Sauce Labs Bolt Fleece Jacket"));
           // Assert.assertTrue("Does not contain the text 'Sauce Labs Onsie'", bodyText.contains("Sauce Labs Onsie"));
            //Assert.assertTrue("Does not contain the text 'Test.allTheThings() T-Shirt (Red)'", bodyText.contains("Test.allTheThings() T-Shirt (Red)"));


        driver.findElement(btnAddFirstProduct).click();
        driver.findElement(btnAddSecondProduct).click();

       // Assert.assertTrue("Does not contain text 'Sauce Labs Backpack'",bodyText.contains("Sauce Labs Backpack"));
       // Assert.assertTrue("Does not contain the text 'Sauce Labs Bolt T-Shirt'",bodyText.contains("Sauce Labs Bolt T-Shirt"));


        driver.findElement(btnCart).click();
        driver.findElement(btnCheckout).click();
        driver.findElement(txtFirstName).sendKeys("Gontse");
        driver.findElement(txtLastName).sendKeys("Molaba");
        driver.findElement(txtZipCode).sendKeys("0632");
        driver.findElement(btnContinue).click();
        driver.findElement(btnFinish).click();

        //Assert.assertTrue("Does not contain text 'THANK YOU FOR YOUR ORDER'",bodyText.contains("THANK YOU FOR YOUR ORDER"));


    }
}
