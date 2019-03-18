import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class QA {
   /* public static void main(String[] args) {

        Properties prop = new Properties();
        File f = new File("/home/ttn/IdeaProjects/Selenium/src/scripts/xyz.properties");
        try {
            FileInputStream fip = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        prop.setProperty("Fname", "PRABH");
        System.out.println(prop.getProperty("Fname"));
    }*/

    @Test
    public void abc(){
        System.out.println("Hello");
    }



}


