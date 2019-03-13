import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Question6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.toolsqa.com/automation-practice-switch-windows/");
        WebElement ele = driver.findElement(By.xpath("//button[text()='New Browser Tab']"));
        ele.click();
        Set<String> session = driver.getWindowHandles();
        Iterator<String> it = session.iterator();
        String p = it.next();
        System.out.println(p);
        String c1 = it.next();
        System.out.println(c1);

        driver.switchTo().window(c1);
        System.out.println(driver.getCurrentUrl());
        driver.findElement(By.xpath("//span[text()='Blogs']")).click();
//driver.close();
    }
}