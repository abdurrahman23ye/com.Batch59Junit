package day5_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JUnitİlkTest {

    @Test
    public void method(){

    WebDriverManager.chromedriver().setup();

    WebDriver driver=new ChromeDriver();

    driver.navigate().to("https://www.amazon.com");
    driver.get("https://www.youtube.com");


}
}
