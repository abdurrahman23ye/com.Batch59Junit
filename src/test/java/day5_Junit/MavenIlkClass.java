package day5_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MavenIlkClass {

    public static void main(String[] args) {

        /*
        1. http://zero.webappsecurity.com sayfasina gidin
2. Signin buttonuna tiklayin
3. Login alanine  “username” yazdirin
4. Password alanine “password” yazdirin
5. Sign in buttonuna tiklayin
6. Pay Bills sayfasina gidin
7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
8. tarih kismina “2020-09-10” yazdirin
9. Pay buttonuna tiklayin
10. “The payment was successfully submitted.” mesajinin ciktigini control edin
         */
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        WebElement login=driver.findElement(By.xpath("//input[@tabindex='1']"));

        login.sendKeys("username");

        WebElement passWord=driver.findElement(By.xpath("//input[@tabindex='2']"));

        passWord.sendKeys("password");

        WebElement signIn=driver.findElement(By.xpath("//input[@tabindex='4']"));

        signIn.click();

        driver.navigate().back();

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();

        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        WebElement amount=driver.findElement(By.xpath("//input[@id='sp_amount']"));

        amount.sendKeys("100");

        WebElement date=driver.findElement(By.xpath("//input[@id='sp_date']"));

        date.sendKeys("2020-09-10");

        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();

        String expectedResult="The payment was successfully submitted.";

        String actuelResult=driver.findElement(By.xpath("//span[@title]")).getText();

        System.out.println("actuelResult = " + actuelResult);

        if(expectedResult.equals(actuelResult)){

            System.out.println("Test passed");
        }else {System.out.println("Test failed");}








    }
}
