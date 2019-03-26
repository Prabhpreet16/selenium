import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Myntra {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/search?q=google&oq=google&aqs=chrome..69i57j69i60j0j69i60l2j0.4029j1j7&sourceid=chrome&ie=UTF-8");
        driver.findElement(By.xpath("//h3[text()='Google']")).click();
        WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));
        ele.sendKeys("Myntra");
        ele.submit();
        //driver.navigate().to("https://www.myntra.com/?gclid=EAIaIQobChMIkszqqsmS4QIV1QorCh249gYfEAAYASAAEgK4m_D_BwE&semp=eoss&utm_source=google&utm_medium=cpc&utm_campaign=&utm_term=myntra&utm_content=&matchtype=e");
        driver.findElement(By.xpath("//a[text()='Men']")).click();
        WebElement abc = driver.findElements(By.xpath("//a[text()='T-Shirts']")).get(4);
        abc.click();
        driver.findElement(By.xpath("//img[@src='https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/7228316/2019/1/30/4d826b89-0119-4c89-8861-4a8cea8ed0691548844555754-DILLINGER-Men-Navy-Blue-Colourblocked-Round-Neck-T-shirt-161-1.jpg']")).click();

        //System.out.println(driver.getCurrentUrl());
        Set<String> s = driver.getWindowHandles();
        System.out.println(driver.getWindowHandles());
        String str[]=new String[s.size()];
        int i=0;
        Iterator<String> itr = s.iterator();

        while (itr.hasNext())
        {
            str[i]=itr.next();
            i++;
        }
        driver.switchTo().window(str[1]);

        driver.findElement(By.xpath("//p[text()='L']")).click();

        //  driver.findElement(By.xpath("//div[@class='pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button pdp-flex pdp-center']")).click();
        driver.findElement(By.xpath("//div[@class='pdp-add-to-bag pdp-button pdp-flex pdp-center']")).click();
        driver.findElement(By.xpath("//span[@class='myntraweb-header-sprite desktop-iconBag sprites-headerBag']")).click();
        driver.findElement(By.xpath("//div[@class='button-base-button ']")).click();
        driver.findElement(By.xpath("//button[@class='login-google login-button']")).click();
        System.out.println(driver.getCurrentUrl());
        Set<String> checkout=driver.getWindowHandles();
        String ch[]=new String[s.size()];
        int j=0;
        Iterator<String> itr1 = s.iterator();

        while (itr.hasNext())
        {
            str[j]=itr1.next();
            j++;
        }
        driver.switchTo().window(str[1]);
        driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("prabh");
        System.out.println(driver.getCurrentUrl());





    }
}