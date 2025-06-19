package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
    }

    @And("I click the login button")
    public void iClickLogin() {
        loginPage.clickLogin();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        // Add assertion here
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}