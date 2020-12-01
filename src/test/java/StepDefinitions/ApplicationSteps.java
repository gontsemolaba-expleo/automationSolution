package StepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//public class ApplicationSteps implements En {

public class ApplicationSteps{

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


    //BuyProducts objectBuyProducts = new  BuyProducts();



    @Given("User is on the Swaglab browser")
    public void user_is_on_the_swaglab_browser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        System.out.println(System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        driver.manage().window().maximize();

        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        ;
    }


    @Given("User logs in with valid username and password")
    public void user_logs_in_with_valid_username_and_password() {

        driver.findElement(txtUserName).sendKeys("standard_user");
        driver.findElement(txtPassword).sendKeys("secret_sauce");
        driver.findElement(btnLogin).click();;
    }

    @When("two items are successfully added to cart")
    public void two_items_are_successfully_added_to_cart() {
        driver.findElement(btnAddFirstProduct).click();
        driver.findElement(btnAddSecondProduct).click();
        driver.findElement(btnCart).click();
        driver.findElement(btnCheckout).click();
    }

    @When("personal details successfully added")
    public void personal_details_successfully_added() {
        driver.findElement(txtFirstName).sendKeys("Gontse");
        driver.findElement(txtLastName).sendKeys("Molaba");
        driver.findElement(txtZipCode).sendKeys("0632");

    }

    @Then("thank you page is displayed")
    public void thank_you_page_is_displayed() {
        driver.findElement(btnContinue).click();
        driver.findElement(btnFinish).click();
    }}



