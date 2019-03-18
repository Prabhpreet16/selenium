import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AutomationTest
{
@Test
        public void tc1() throws IOException {
            Properties properties = new Properties();
            File f = new File("/home/ttn/Projects/QaTest/exe/QA.properties");
            FileInputStream fin = new FileInputStream(f);
            properties.load(fin);
            System.setProperty("webdriver.chrome.driver", "exe1/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("http://newtours.demoaut.com/mercuryreservation2.php");
            driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
            driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(properties.getProperty("fname"));
            driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(properties.getProperty("lname"));
            driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(properties.getProperty("phone"));
            driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(properties.getProperty("email"));
            driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(properties.getProperty("addr"));
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys(properties.getProperty("city"));
            driver.findElement(By.xpath("//input[@name='state']")).sendKeys(properties.getProperty("state"));
            driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(properties.getProperty("pc"));
            WebElement registerdropdown = driver.findElement(By.name("country"));
            Select dropdown = new Select(registerdropdown);
            dropdown.selectByVisibleText(properties.getProperty("country"));
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys(properties.getProperty("email"));
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("passwd"));
            driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(properties.getProperty("cpasswd"));
            driver.findElement(By.xpath("//input[@name='register']")).click();

    String userName= "Dear "+properties.getProperty("fname")+" "+properties.getProperty("lname")+",";
    String userNameActual=driver.findElement(By.xpath("//b")).getText();
    Assert.assertEquals(userName,userNameActual);



        }
    }

