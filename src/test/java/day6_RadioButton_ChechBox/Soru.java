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

public class Soru {
    /*Soru 3

            1. “https://www.saucedemo.com” Adresine gidin
            2. Username kutusuna “standard_user” yazdirin
3. Password kutusuna “secret_sauce” yazdirin
4. Login tusuna basin
5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
6. Add to Cart butonuna basin
7. Alisveris sepetine tiklayin
8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
9. Sayfayi kapatin

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
    public void test1() throws InterruptedException {

        driver.navigate().to("https://www.saucedemo.com");

        WebElement userName=driver.findElement(By.
                xpath("//input[@placeholder='Username' and @data-test='username']"));
        userName.sendKeys("standard_user");

        WebElement passWord=driver.findElement(By.
                xpath("//input[@placeholder='Password' and @type='password']"));
        passWord.sendKeys("secret_sauce");

       driver.findElement(By.xpath("//input[@data-test='login-button' and @id='login-button']")).click();

      WebElement first=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String first1=first.getText();

        System.out.println(first1);

        first.click();


  WebElement add= driver.findElement(By.xpath("//Button[@id='add-to-cart-sauce-labs-backpack' and @name='add-to-cart-sauce-labs-backpack']"));


        add.click();


        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        WebElement sepet=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        String sepet1=sepet.getText();

        System.out.println("sepet1 = " + sepet1);

        Assert.assertEquals(sepet1,first1);


    }

}
