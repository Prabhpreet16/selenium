import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Question1 {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        WebElement testd = driver.findElement(By.xpath("//button[text()='Click me!']"));
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement ele = driver.findElement(By.xpath("//button[text()='Click for Prompt Box']"));
        testd.click();
        driver.switchTo().alert().sendKeys("prabh");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.switchTo().alert().accept();

    }
}
