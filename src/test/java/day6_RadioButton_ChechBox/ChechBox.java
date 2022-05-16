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

public class ChechBox {

    /*
    CheckBox

1. Bir class oluşturun : CheckBoxTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    WebDriver driver;

    @Before
    public void SetUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearsDown(){
        driver.close();
    }

    @Test
    public void test1(){


        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void test2(){
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

        WebElement chech1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chech2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if(!chech1.isSelected()){chech1.click();}
        if(!chech2.isSelected()){chech2.click();}



    }

}
