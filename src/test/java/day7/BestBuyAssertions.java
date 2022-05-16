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

public class BestBuyAssertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
testleri yapin

○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
○ logoTest => BestBuy logosunun görüntülendigini test edin
○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    WebDriver driver;

    @Before
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.bestbuy.com/");

    }


   @After
   public void tearsDown() {driver.close();
    }

    @Test
    public void test1() {

        //  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String URL = driver.getCurrentUrl();

        Assert.assertEquals("https://www.bestbuy.com/", URL);
    }

    @Test
    public void test2() {

      //  ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String baslik = driver.getTitle();

        Assert.assertFalse(baslik.contains("Rest"));
    }

    @Test
    public void test3() {

        //○ logoTest => BestBuy logosunun görüntülendigini test edin

       WebElement logo = driver.findElement(By.xpath("(//img[@class='logo' and @alt='Best Buy Logo'])[1]"));

      Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void test4() {

      //  ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement francais = driver.findElement(By.xpath("//button[@lang='fr']"));

        Assert.assertTrue(francais.isDisplayed());
    }


}
