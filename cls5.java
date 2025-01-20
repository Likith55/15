package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.*;

public class cls5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            // Update this path to match your CSV file location
            File file = new File("C:\\Users\\likit\\OneDrive\\Desktop\\testdata.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            br.readLine(); // skip header
            String line;
            
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");
                    driver.get("https://facebook.com");
                    Thread.sleep(1000);  // Wait for page load
                    
                    driver.findElement(By.id("email")).sendKeys(data[0].trim());
                    driver.findElement(By.id("pass")).sendKeys(data[1].trim());
                    driver.findElement(By.name("login")).click();
                    Thread.sleep(1000);
                    
                    System.out.println("Tested login for: " + data[0]);
                } catch (Exception e) {
                    System.out.println("Failed to test login: " + e.getMessage());
                }
            }
            br.close();
            
        }  catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}