import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class Question2 {
    public static void main(String[] args) throws InterruptedException {
        Question2a();
        Question2b();
        Question2cd();
    }
    static void Question2a() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement testd = driver.findElement(By.id("multi-select"));
        testd.click();
        Select dropdown = new Select(testd);
        System.out.println(dropdown.isMultiple());
    }
    static void Question2b() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement testd = driver.findElement(By.id("multi-select"));
        Select dropdown = new Select(testd);
        List<WebElement> ele = dropdown.getOptions();
        Iterator<WebElement> iterator = ele.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getText());
        }
    }
    static void Question2cd() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        WebElement testd = driver.findElement(By.id("multi-select"));
        Select dropdown = new Select(testd);
        List<WebElement> ele = dropdown.getOptions();
        dropdown.selectByValue("New Jersey");
        dropdown.selectByValue("New York");
        dropdown.selectByValue("Texas");
        WebElement testd1 = driver.findElement(By.id("printMe"));
        testd1.click();
        System.out.println("All Selected Options");
        List<WebElement> l2 = dropdown.getAllSelectedOptions();
        for(int i = 0 ; i < l2.size() ; i++){
            System.out.println(l2.get(i).getText());
        }

        System.out.println("First Selected Option "+ dropdown.getFirstSelectedOption().getText());
        System.out.println("");

        dropdown.deselectAll();
        driver.close();


    }
}
