package day6_RadioButton_ChechBox;

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

public class AmazonTest {

    /*
    Tekrar Testi
1-C01_TekrarTesti isimli bir class olusturun
2- https://www.amazon.com/ adresine gidin
3- Browseri tam sayfa yapin
4-Sayfayi “refresh” yapin
5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
6- Gift Cards sekmesine basin
7- Birthday butonuna basin
8- Best Seller bolumunden ilk urunu tiklayin
9- Gift card details’den 25 $’i secin
10-Urun ucretinin 25$ oldugunu test edin
10-Sayfayi kapatin
     */

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){

     //   driver.close();
    }

    @Test
    public void test1(){
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        driver.getTitle();
        String actuelResult=driver.getTitle();
        String expectedResult="Spend less";


        Assert.assertTrue(actuelResult.contains(expectedResult));

        WebElement gift= driver.findElement(By.
                xpath("//a[contains(text(),'Gift Cards')]"));

        gift.click();

        driver.findElement(By.xpath("//img[@alt='Birthday gift cards']")).click();

        driver.findElement(By.
                xpath("//img[@alt='Amazon.com eGift Card' and @data-a-hires='https://images-na.ssl-images-amazon.com/images/I/41zRJ1VZdYL._AC_SX368_.jpg']")).click();
        driver.findElement(By.xpath("//button[@value='25']")).click();

        WebElement cost=driver.findElement(By.xpath("//span[@id='gc-live-preview-amount']"));

        Assert.assertTrue(cost.getText().equals("$25.00"));

    }

    @After
    public void tearsDown(){
        driver.close();

    }



}
