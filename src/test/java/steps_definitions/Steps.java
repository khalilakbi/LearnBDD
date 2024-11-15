package steps_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
    WebDriver driver;

    @Given("user open orangeHRM application")
    public void user_open_orange_hrm_application() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

    }

    @When("user enter valid username")
    public void user_enter_valid_username() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys("Admin");
    }

    @When("user enter valid password")
    public void user_enter_valid_password() {
        driver.findElement(By.name("password")).sendKeys("admin123");
    }


    @When("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.xpath("//button")).click();
    }

    @Then("account page should be open")
    public void account_page_should_be_open() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @When("user enter username as {string}")
    public void user_enter_username_as(String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @When("user enter password as {string}")
    public void user_enter_password_as(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    //    @When("user enter invalid password")
//    public void user_enter_invalid_password() {
//        driver.findElement(By.name("password")).sendKeys("admin1");
//    }
    @Then("warning msg display")
    public void warning_msg_display() throws InterruptedException {
        Thread.sleep(2000);
        boolean isMSgDisplay = driver.findElement(By.xpath("//p[text() = 'Invalid credentials']")).isDisplayed();
        Assert.assertTrue(isMSgDisplay);
    }
}
