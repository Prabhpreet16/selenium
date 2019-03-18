import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class AutomationTest2 {
    @Test
    public void tc2() throws IOException {
        Properties properties = new Properties();
        File f = new File("/home/ttn/Projects/QaTest/exe/QA.properties");
        FileInputStream fin = new FileInputStream(f);
        properties.load(fin);
        System.setProperty("webdriver.chrome.driver", "exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
        driver.findElement(By.xpath("//a[text()='SIGN-ON']")).click();
        driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(properties.getProperty("email"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(properties.getProperty("passwd"));

        driver.findElement(By.xpath("//input[@name='login']")).click();
        String str = driver.getCurrentUrl();
        Assert.assertEquals(str, "http://newtours.demoaut.com/mercuryreservation.php");
        String type = properties.getProperty("FlightType");
        type = type.replace(" ", "").toLowerCase();
        driver.findElement(By.xpath("//input[@value='" + type + "']")).click();
        WebElement passengerdropdown = driver.findElement(By.name("passCount"));
        Select dropdown = new Select(passengerdropdown);
        dropdown.selectByVisibleText(properties.getProperty("passengercount"));
        WebElement citydropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select dropdown1 = new Select(citydropdown);
        dropdown1.selectByVisibleText(properties.getProperty("Dcity"));
        WebElement monthdropdown = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select dropdown2 = new Select(monthdropdown);
        dropdown2.selectByVisibleText(properties.getProperty("Dmonth"));
        WebElement Ddatedropdown = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dropdown3 = new Select(Ddatedropdown);
        dropdown3.selectByVisibleText(properties.getProperty("Ddate"));
        WebElement Acitydropdown = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select dropdown4 = new Select(Acitydropdown);
        dropdown4.selectByVisibleText(properties.getProperty("Acity"));
        String str1 = properties.getProperty("Acity");
        String str2 = properties.getProperty("Dcity");
        System.out.println(str1);
        boolean a;
        //To check whether Departure city is not same as the arrival city
       // Assert.assertNotEquals(str1,str2);
        WebElement Amonthdropdown = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select dropdown5 = new Select(Amonthdropdown);
        dropdown5.selectByVisibleText(properties.getProperty("Amonth"));
        WebElement Adatedropdown = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dropdown6 = new Select(Adatedropdown);
        dropdown6.selectByVisibleText(properties.getProperty("Adate"));
        String str3 = properties.getProperty("Dmonth");
        String str4 = properties.getProperty("Ddate");
        String str5 = properties.getProperty("Amonth");
        String str6 = properties.getProperty("Adate");
        String months[] =
                {
                        "January", "February", "March", "April", "May",
                        "June", "July", "August", "September", "October",
                        "November", "December"
                };
        int j = 0;
        int k = 0;
        for (int i = 0; i < 12; i++) {
            if (str3.equals(months[i])) {
                j = i;
            }
            if (str5.equals(months[i])) {
                k = i;
            }
        }
        //To check Arrival month cant be less the departure month
        if (k < j) {
            boolean abc = false;
            Assert.assertFalse(abc = true, "Arrival month cant be less than departure month");
        }
        if (str3.equals(str5)) {
            Assert.assertNotEquals(str4, str6);
        }
        //To check Arrival date cant be less than the Departure date
        if (str3.equals(str5)) {
            int aa = Integer.parseInt(str4);
            int bb = Integer.parseInt(str6);
            if (bb < aa) {
                boolean xyz = false;
                Assert.assertFalse(xyz = true, "Arrival date cant be less than Departure date in same month");
            }

        }
        driver.findElements(By.xpath("//input[@name='servClass']")).get(2).click();
        WebElement prefrence = driver.findElement(By.name("airline"));
        new Select(prefrence).selectByVisibleText("Unified Airlines");

        driver.findElement(By.name("findFlights")).submit();


        driver.findElements(By.name("outFlight")).get(2).click();

        driver.findElements(By.name("outFlight")).get(2).click();

//
        driver.findElement(By.name("reserveFlights")).submit();
        //THIS IS USED FOR END TO END DETAILS
        /*driver.findElement(By.xpath("//input[@name='passFirst0']")).sendKeys("Prabh");
        driver.findElement(By.xpath("//input[@name='passLast0']")).sendKeys("Singh");
        driver.findElement(By.xpath("//input[@name='passFirst1']")).sendKeys("XYZ");
        driver.findElement(By.xpath("//input[@name='passLast1']")).sendKeys("ABC");
        driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("1234567891234567");*/
        //To check empty passenger details are accepted
        driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
        String current_url=driver.getCurrentUrl();
        String current_url2="http://newtours.demoaut.com/mercurypurchase2.php";
        Assert.assertNotEquals(current_url,current_url2);
      //  driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']")).click();


        //End to end to check
        //String url=driver.getCurrentUrl();
        //String url2="http://newtours.demoaut.com/mercurysignon.php";
        //Assert.assertEquals(url,url2,"Correct url is opened ");



    }
}


