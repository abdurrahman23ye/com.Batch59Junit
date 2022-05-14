package day5_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AmazonSearchTest {

    public static void main(String[] args) {
        /*
        CLASS WebDriver AYARLARI

WebDriverManager.chromedriver( ).setup( );
WebDriver driver = new ChromeDriver( );

Class Work Amazon Search Test

1- https://www.amazon.com/ sayfasina gidelim
2- arama kutusunu locate edelim
3- “Samsung headphones” ile arama yapalim
4- Bulunan sonuc sayisini yazdiralim
5- Ilk urunu tiklayalim
6- Sayfadaki tum basliklari yazdiralim
         */

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        aramaKutusu.sendKeys("Samsung headphones");

        aramaKutusu.submit();

       WebElement aramaSonucu=driver.findElement(By.xpath("//*[contains(text(),'1-16 of')]"));
      //  WebElement aramaSonucu=driver.findElement(By.xpath("//*[startsWith(text(),'1-16 of')]"));

        String aramaSonucu1=aramaSonucu.getText();

        System.out.println(aramaSonucu1.replace("1-16 of ", "").replace(" results for", ""));

        WebElement list=driver.findElement(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));

        list.click();

        List<WebElement> basliklar=driver.findElements(By.xpath("//h1"));
        List<WebElement> basliklar1=driver.findElements(By.xpath("//h2"));
        List<WebElement> basliklar2=driver.findElements(By.xpath("//h3"));
        List<WebElement> basliklar3=driver.findElements(By.xpath("//h4"));
        List<WebElement> basliklar4=driver.findElements(By.xpath("//h5"));
        List<WebElement> basliklar5=driver.findElements(By.xpath("//h6"));
        List<WebElement> basliklar6=new ArrayList<>();

        basliklar6.addAll(basliklar);
        basliklar6.addAll(basliklar1);
        basliklar6.addAll(basliklar2);
        basliklar6.addAll(basliklar3);
        basliklar6.addAll(basliklar4);
        basliklar6.addAll(basliklar5);
        basliklar6.addAll(basliklar6);



        for (WebElement each: basliklar6
             ) {
            System.out.println(each.getText());}


    }
}
