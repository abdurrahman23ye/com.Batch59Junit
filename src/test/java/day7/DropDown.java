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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDown {

    /* amazon'a gidip
   dropdown'dan books secenegini secip
   Java aratalim
   ve arama sonuclarinin Java icerdigini test edelim
 */
    WebDriver driver;
    @Before
    public void SetUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://www.amazon.com/");

    }


    @After
    public void tearsDown() {driver.close();}



    @Test
    public void test1() {

        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(ddm);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("java");

        aramaKutusu.submit();

        WebElement sonuc=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String sonuc1=sonuc.getText();

        Assert.assertTrue(sonuc1.contains("java"));



    }

    }