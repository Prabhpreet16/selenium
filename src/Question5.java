import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Question5 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/ttn/IdeaProjects/Selenium/exe1/chromedriver");
        WebDriver driver = new ChromeDriver();
       // driver.navigate().to("http://demo.automationtesting.in/Frames.html");
        //System.out.println(driver.findElements(By.xpath("//iframe")).size());
        driver.navigate().to("http://www.londonfreelance.org/courses/frames/index.html");
        driver.switchTo().frame("navbar");
      WebElement ele= driver.findElement(By.xpath("//a[text()='Sample content']"));
      ele.click();
      driver.switchTo().defaultContent();
      driver.switchTo().frame("content");

      String expected="Acid-free paper for the digital age";
        String actual=driver.findElement(By.xpath("//h2")).getText();
        if(expected.equals(actual)){
            System.out.println("The actual and expected header matches");
        }


    }
}
