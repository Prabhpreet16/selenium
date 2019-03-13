import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question4
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        driver.switchTo().frame("SingleFrame");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Prabh");

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']")));
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Prabh");
    }
}
