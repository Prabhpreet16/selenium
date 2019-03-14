package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class launchchrome {
    public static void main(String[] args) throws Exception {
        //question_two();
        //question_one();
        //question_three();
        //question_four();
        // question_five_and_six();
        //Dropdown();
        // FramePrac();
        // win1();
        //question_eleven();
        //table();
        prop();
    }

    /*  static void question_two() throws InterruptedException {
          System.setProperty("webdriver.gecko.driver", "exe1/geckodriver");
          WebDriver driver = new FirefoxDriver();
          driver.navigate().to("https://www.google.com/");
          Thread.sleep(5000);
          driver.close();
      }*/
    static void question_one() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(5000);
        driver.close();
    }

    static void question_three() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        WebElement ele = driver.findElement(By.name("q"));
        ele.sendKeys("To the new");
        ele.submit();
    }

    static void question_four() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/");
        driver.findElement(By.xpath("//a[text()='contact us']")).click();
        driver.findElement(By.id("h-contact-us")).click();
    }

    static void question_five_and_six() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tothenew.com/");
        driver.findElement(By.xpath("//a[text()='contact us']")).click();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
    }

    static void question_eleven() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ttn/Downloads/Registration%20(1).html");
        driver.findElement(By.xpath("//*[@ng-model='FirstName']")).sendKeys("Prabh");
        driver.findElement(By.xpath("//*[@ng-model='LastName']")).sendKeys("Preet");
        driver.findElement(By.xpath("//*[@ng-model='Adress']")).sendKeys("West Delhi");
        driver.findElement(By.xpath("//*[@ng-model='EmailAdress']")).sendKeys("prabhpreet.singh@tothenew.com");
        driver.findElement(By.xpath("//*[@ng-model='Phone']")).sendKeys("8826757025");
        driver.findElements(By.name("radiooptions")).get(0).click();
        driver.findElements(By.id("checkbox1")).get(0).click();
        driver.findElement(By.xpath("//*[@ng-model='Password']")).sendKeys("Prabh123");
        driver.findElement(By.xpath("//*[@ng-model='CPassword']")).sendKeys("Prabh123");
        // driver.findElement(By.id("submitbtn")).click();
        System.out.println(driver.findElement(By.id("Button1")).isEnabled());
        //  driver.findElement(By.id("submitbtn")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//input[@type='radio']"));
        if ("Male".equals(elements.get(0).getAttribute("value"))) {
            System.out.println("Male is Selected");
        } else {
            System.out.println("Female is Selected");

        }
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//h1[contains(text(),'Automation Demo Site')]")).isDisplayed());
    }

    static void question_twelve() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("file:///home/ttn/Downloads/DemoPage%20(4).html");
        List<WebElement> wb = driver.findElements(By.name("Demo"));
        wb.get(0).sendKeys("Prabh");
        wb.get(1).sendKeys("Preet");
        wb.get(2).sendKeys("prabhpreet.singh@tothenew.com");

    }

    static void table() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://demo.guru99.com/test/web-table-element.php");
        //List<WebElement> ele = driver.findElements(By.xpath("//table[@class='dataTable']//tr"));
        //System.out.println(ele.size());
        //List<WebElement> ele1 = driver.findElements(By.xpath("//table[@class='dataTable']//th"));
        //SystQuestion1em.out.println(ele1.size());
        List<WebElement> ele = driver.findElements(By.xpath("//tr//td"));

        for (int i = 2; i <= ele.size(); i++) {
            List<WebElement> ele1 = driver.findElements(By.xpath("//tr[" + i + "]//td"));
            for (int j = 1; j <= ele1.size(); j++) {
                String str = driver.findElement(By.xpath("//tr[" + i + "]//td[" + j + "]")).getText();
                System.out.println(str);
            }
        }
    }

    static void prop() throws Exception {
        Properties prop = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Selenium/src/scripts/xyz.properties");
        FileInputStream fip = new FileInputStream(f);
        prop.setProperty("Fname", "PRABH");
        System.out.println(prop.getProperty("Fname", "PRABH"));
    }

    static void TestNg() throws Exception {

    }

}
