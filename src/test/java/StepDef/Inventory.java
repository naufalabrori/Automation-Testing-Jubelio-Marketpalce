package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import config.env_target;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Inventory extends env_target{
    @Given("User in jubelio homepage")
    public void userInJubelioHomepage() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/button"))
        );

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[1]/div/input")).sendKeys("qa.rakamin.jubelio@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/div[2]/div/input")).sendKeys("Jubelio123!");
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[2]/div/form/button")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wrapper\"]/nav/div/li"))
        );

    }

    @When("User select inventory menu")
    public void userSelectInventoryMenu() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"wrapper\"]/nav/div/div/ul/li[2]/ul/li[2]/a")).click();
    }

    @And("User select inventory adjustment")
    public void userSelectInventoryAdjustment() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div/div[1]/div[2]/div/button[2]")).click();
    }

    @And("User select item to be adjusted")
    public void userSelectItemToBeAdjusted() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div/input")).sendKeys("15ACH6");
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[1]/div[1]/div[2]/div/div/div/span/button")).click();

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div[11]/div"))
        );
    }

    @Then("User save inventory adjustment")
    public void userSaveInventoryAdjustment() throws InterruptedException {
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div[2]/div/div/div/div/div[3]/div/button")).click();
    }
}
