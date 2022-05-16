package day6_RadioButton_ChechBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButton {

    /*Radio Button

1. Bir class oluşturun : RadioButtonTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
- https://www.facebook.com adresine gidin
- Cookies’i kabul edin
- “Create an Account” button’una basin
- “radio buttons” elementlerini locate edin
- Secili degilse cinsiyet butonundan size uygun olani secin

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
        driver.navigate().to("https://www.facebook.com");

        WebElement hesapOlustur=driver.
                findElement(By.xpath("//a[@role='button' and @ajaxify='/reg/spotlight/' and @data-testid='open-registration-form-button' ]"));
        hesapOlustur.click();

        WebElement erkek=driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));

        erkek.click();


    }
}