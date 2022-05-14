package Summaries;

public class Day4Summary {

   /* Absolute xpath

    * Bir elementi en baştan başlayarak adresini göstererek Locate etme.

    * Adress // ile başlayıp // ile biter araya her aşamada / konur.

    Örnek: //Html/body/div/div// gibi

    bir adreste aynı tagtan birkaç tane varsa kaçıncı sıradaki olduğunu yazarız //Html/body/div[2]/div// gibi...

    İndex mantığı ama 0'dan başlanmayacak, birden başlanacak.

    Kullanışlı değil son çare.


    */

    /* relative xpath

    cssSelector ile birlikte en pratik yöntem.

    tırnak içinde en başa her zaman// ardından tag köşeli parantezin içinde[başta @+artribute= tek tırnak içinde value]

    Ör: //input[@id='a'];


    //input tek input varsa bu da kullanılabilir.

    “// * [@type=‘text’]” -> input önemli değil type cinsi text value e sahip olan

   "//input[@ *=‘text’]”-> input ve herhangi bir özeliiği text olan

   “//input[@type]”-> type özelliği olan input

   Exact Text(Belirli bir text) ile element bulma:

driver.findElement(By.xpath(“//tagname[.='text name']” ));
driver.findElement(By.xpath(“//*[.='text name'] ” ));

Belirli bir metni içeren bir öğeyi bulmak için şunları kullanabiliriz:

driver.findElement(By.xpath(“//*[contains(text(),'piece of text')]” ));


Tek attribute ile unique bir sonuca ulasamazsak birden fazla attribute yazabiliriz

driver.findElement(By.xpath(“//div[@id='logo' or class='flex-col logo’ ] ”));
driver.findElement(By.xpath(“//*[text()='exact text with extra space and all'] ” ));

driver.findElement(By.xpath(“//div[@id='logo’ and class='flex-col logo’ ] ”));


CSS Selector

xpath'in aynısı sadece @ yok.

ayrıca kısa yollar

) css="tagName#idValue" veya sadece css="#idValue" =>yalnızca id value ile çalışır

driver.findElement(By.cssSelector("input#session_password"));

3 ) css="tagName.classValue" veya sadece css=".classValue"=>yalnızca class value ile çalışır

driver.findElement(By.cssSelector(".form-control"));

Elementin etrafındaki elementlerle by değil de with ile locate edilebilir.

   WebElement mountie= driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(bostonWE).toLeftOf(sailorWE));
     */




}
