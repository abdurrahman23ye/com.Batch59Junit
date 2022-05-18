package day9_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandles {
    /*

    ● Tests package’inda yeni bir class olusturun: WindowHandle2
● https://the-internet.herokuapp.com/windows adresine gidin.
            ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
            ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            ● Click Here butonuna basın.
            ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            ● Sayfadaki textin “New Window” olduğunu doğrulayın.
            ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*
    @After
    public void tearDown(){
        driver.quit();
    }

     */
    @Test
    public void test01(){

        driver.get("https://the-internet.herokuapp.com/windows");

        Assert.assertTrue(driver.
                findElement(By.xpath("//h3")).getText().equals("Opening a new window"));

        Assert.assertTrue(driver.getTitle().equals("The Internet"));

        System.out.println(driver.getWindowHandle());

        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

       Set<String> handles= driver.getWindowHandles();

       String ikinciSayfa="";
       String ilkSayfa="";

        for (String each: handles
             ) {if(!each.equals(driver.getWindowHandle())){ikinciSayfa=each;}else {ilkSayfa=each;}

        }

        driver.switchTo().window(ikinciSayfa);

        Assert.assertTrue(driver.getTitle().equals("New Window"));
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("New Window"));
        driver.switchTo().window(ilkSayfa);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));



    }
}
