package Summaries;

public class Day2Summary {


    /*  driver.manage().window().fullscreen();
    driver.getTitle();
       driver.getCurrentUrl();
       driver.get("https://www.amazon.com.tr");
         driver.getPageSource().contains("spend less");
         System.out.println(driver.getWindowHandle());
          driver.navigate().to("https://www.amazon.com")
             driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
      driver.quit();

     *//*
       driver.manage().window().getSize();
       driver.manage().window().setSize(new Dimension(700,600));
        System.out.println(driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(15,15));
    driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().window().minimize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

************************************************************************

     driver.manage().window().fullscreen();//Tam sayfa yap.

       driver.getTitle();//başlığı al.

       driver.getCurrentUrl();//URL'i al.

       driver.get("https://www.amazon.com.tr");//sayfaya git

         driver.getPageSource().contains("spend less");//sayfa kaynağında ara

         System.out.println(driver.getWindowHandle());//Benzersiz olarak açılan windowun hascodunu verir
        //Bu kodlarla sayfalar arasında dolaşırız.

          driver.navigate().to("https://www.amazon.com");//driver.get'in aynısı

        driver.navigate().to("https://www.facebook.com");

        driver.navigate().back();//geri dön
        driver.navigate().forward();//ileri git

        driver.navigate().refresh();//yenile

        driver.close();//kapat

        System.out.println(driver.manage().window().getSize());// pencere ölçülerini öğren


        driver.manage().window().setSize(new Dimension(700,600));//ölçü değiştirme

        System.out.println(driver.manage().window().getPosition());//pencere konumunu öğren
        driver.manage().window().setPosition(new Point(15,15));//pencere konum değiştirme

        driver.manage().window().maximize();//büyüt
        driver.manage().window().fullscreen();//tam ekran
        driver.manage().window().minimize();//görev çubuğuna indir.

         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); /* Bir sayfa açılırken elementlerin yüklenmesi için
        zaman ihtiyac vardır. Bu şekilde Maksimum(Bulursa o kadar değil.) 15 saniye elementlerin
        yüklenmesi beklenir.İleride ayrıntlı öğreneceğiz.

        thread.sleep kullanırsak her senaryoda bekleriz.

        driver.close();//son açılan tabı kapatır.

        driver.quit();//bütün tablari kapatir.
     */






}
