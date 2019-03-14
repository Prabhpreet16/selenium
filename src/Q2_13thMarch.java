import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Q2_13thMarch {
    public static void main(String[] args) throws InterruptedException, IOException {
            Properties properties = new Properties();
            File f = new File("exe/abc.properties");
            FileInputStream fin = new FileInputStream(f);
            properties.load(fin);
            //System.out.println(properties.getProperty("user"));

            System.setProperty("webdriver.chrome.driver", "/home/ttn/Projects/Selenium/exe1/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("file:///home/ttn/Downloads/Registration.html");
            List<WebElement> name = driver.findElements(By.name("Demo"));
            System.out.println(name.size());
            name.get(0).sendKeys(properties.getProperty("fname"));
            name.get(1).sendKeys(properties.getProperty("lname"));
            name.get(2).sendKeys(properties.getProperty("email"));
            driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(properties.getProperty("addr"));
            driver.findElement(By.xpath("//input[@ng-model='Phone']")).sendKeys(properties.getProperty("phone"));
            List<WebElement> gender = driver.findElements(By.xpath("//input[@ng-model='radiovalue']"));
            for (WebElement a:gender){
                if (a.getAttribute("value").equals("Male"))
                    a.click();
            }
            List<WebElement> hobb = driver.findElements(By.xpath("//input[@type='checkbox']"));
            for (WebElement a:hobb) {
                if (a.getAttribute("value").equals("Cricket"))
                    a.click();
            }
            List<WebElement> pass = driver.findElements(By.xpath("//input[@type='password']"));
            for (WebElement a:pass) {
                a.sendKeys(properties.getProperty("passwd"));
            }
        }


    }
