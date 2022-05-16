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

public class Tekrar {

    /*Tekrar Testi

1-C01_TekrarTesti isimli bir class olusturun
2- https://www.google.com/ adresine gidin
3- cookies uyarisini kabul ederek kapatin
4-Sayfa basliginin “Google” ifadesi icerdigini test edin
5- Arama cubuguna “Nutella” yazip aratin
6-Bulunan sonuc sayisini yazdirin
7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
8-Sayfayi kapatin

     */


    WebDriver driver;

    @Before
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

 @After
 public void tearsDown() {driver.close();}

    @Test
    public void test1() {

        driver.navigate().to("https://www.google.com/");

        String baslik = driver.getTitle();

        Assert.assertTrue(baslik.contains("Google"));

        WebElement aramaCubugu = driver.findElement(By.xpath("//input[@name='q' and @type='text']"));

        aramaCubugu.sendKeys("Nutella");

        aramaCubugu.submit();

        WebElement aramaSonucu=driver.findElement(By.xpath("//div[@id='result-stats']"));

        String aramaSon=aramaSonucu.getText();

        int aramaSonuc=Integer.parseInt(aramaSon.substring(0,aramaSon.length()-14).replace("Yaklaşık ","").
                replace(" sonuç bulundu","").
                replaceAll("\\D",""));

        System.out.println("Bulunan arama sonuçları: "+aramaSonuc);

        Assert.assertTrue(aramaSonuc>10000000);



    }

}
