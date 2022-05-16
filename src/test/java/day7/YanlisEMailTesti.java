package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanlisEMailTesti {
    /*
    1. Bir Class olusturalim YanlisEmailTesti
2. http://automationpractice.com/index.php sayfasina gidelim
3. Sign in butonuna basalim
4. Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */

    WebDriver driver;

    @Before
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

    }


   @After
   public void tearsDown() {driver.close();}

    @Test
    public void test1() throws InterruptedException {

        driver.navigate().to("http://automationpractice.com/index.php");

        driver.findElement(By.xpath("//a[@class='login' and @title='Log in to your customer account']")).click();

        WebElement eMail=driver.findElement(By.xpath("//input[@type='text' and @class='is_required validate account_input form-control']"));


        eMail.sendKeys("sdsfsfsf");

        eMail.submit();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.
                xpath("//div[@class='alert alert-danger' and @id='create_account_error']")).isDisplayed());



    }

}
