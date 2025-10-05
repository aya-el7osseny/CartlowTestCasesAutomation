package CartlowTestCasesAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://cartlow.com/uae/en");

        driver.findElement(By.xpath("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'login') or contains(., 'Login')]")).click();

        driver.findElement(By.name("email")).sendKeys("your_email_here");
        driver.findElement(By.name("password")).sendKeys("your_password_here");

        driver.findElement(By.xpath("//button[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'login') or contains(., 'Login')]")).click();

        try { Thread.sleep(3000); } catch (InterruptedException e) { /* ignore */ }

        System.out.println("login test executed");

        driver.quit();
    }
}