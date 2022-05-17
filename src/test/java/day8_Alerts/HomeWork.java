package day8_Alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomeWork {
  /*  1. http://zero.webappsecurity.com/ Adresine gidin
            2. Sign in butonuna basin
3. Login kutusuna “username” yazin
4. Password kutusuna “password.” yazin
5. Sign in tusuna basin
6. Pay Bills sayfasina gidin
7. “Purchase Foreign Currency” tusuna basin
8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase”

   */

    WebDriver driver;

    @Before
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("http://zero.webappsecurity.com/");

    }

    @Test
    public void test01() throws InterruptedException {

        driver.findElement(By.xpath("//button[@id]")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();

        WebElement ddm=driver.findElement(By.xpath("//select[@id='pc_currency']"));

        Select select=new Select(ddm);

        select.selectByVisibleText("Eurozone (euro)");

        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("100");

        WebElement dollar=driver.findElement(By.xpath("(//label[@class='radio inline'])[2]"));


        Assert.assertFalse(dollar.isSelected());

        WebElement selected=driver.findElement(By.xpath("(//label[@class='radio inline'])[3]"));

        selected.click();

        driver.findElement(By.xpath("//input[@type='button']")).click();



    WebElement pchs= driver.findElement(By.
                xpath("//input[@type='submit' and @value='Purchase' and @id='purchase_cash']"));

        Thread.sleep(5000);

        pchs.click();






    }

}