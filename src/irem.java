import Utility.BaseDriver;
import Utility.My.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class irem extends BaseDriver {
    @Test
    public void OturumAcma(){

        driver.get("https://demowebshop.tricentis.com/");
        WebElement OturumAcma= driver.findElement(By.xpath("//font[text()='iremt8202@gmail.com']"));
        OturumAcma.click();
        MyFunc.wait(2);

        WebElement Giris= driver.findElement(By.xpath("//font[text()='Giriş yapmak']"));
        Giris.click();
        MyFunc.wait(2);

        WebElement mail= driver.findElement(By.cssSelector("input[class='email']"));
        mail.sendKeys("iremt8202@gmail.com");
        MyFunc.wait(2);

        WebElement sifre= driver.findElement(By.cssSelector("input[class='password']"));
        sifre.sendKeys("gtfeggh123AB");
        MyFunc.wait(2);

        WebElement Giriss= driver.findElement(By.cssSelector("input[type='submit'][value='Giriş yapmak']"));
        Giriss.click();
        MyFunc.wait(2);

    }


}
