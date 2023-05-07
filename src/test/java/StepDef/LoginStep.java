package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import config.env_target;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStep extends env_target {
    @Given("User in login page")
    public void userInLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/button"))
        );
    }

    @When("User fill email and password")
    public void userFillEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys("qa.rakamin.jubelio@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Jubelio123!");
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/button")).click();
    }

    @Then("User in homepage")
    public void userInHomepage() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/nav/div/li"))
        );
    }

    @When("User fill invalid email and password")
    public void userFillInvalidEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys("qa.rakamin.jubelio@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Jubelio321!");
    }

    @Then("User get error message")
    public void userGetErrorMessage() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("app-alert"))
        );
    }
}
