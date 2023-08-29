import Utility.BaseDriver;
import Utility.My.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class irem extends BaseDriver {
    @Test
    public void OturumAcma() {
        String eMail="iremt8202@gmail.com";

        driver.get("https://demowebshop.tricentis.com/");

        WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
        Login.click();
        MyFunc.wait(2);

       WebElement Mail = driver.findElement(By.cssSelector("input[id='Email']"));
        Mail.sendKeys(eMail);
        MyFunc.wait(2);

        WebElement Password = driver.findElement(By.cssSelector("input[type='password']"));
        Password.sendKeys("gtfeggh123AB");
        MyFunc.wait(2);

        WebElement LOGin = driver.findElement(By.cssSelector("input[value='Log in']"));
        LOGin.click();
        MyFunc.wait(2);

        WebElement userMail= driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]"));
        Assert.assertTrue(userMail.getText().contains(eMail));



        BekleVeKapat();
    }
        @Test
    public void NegatifOturumAcma1(){
        driver.get("https://demowebshop.tricentis.com/");
        String mail="";
        String password="";
        String MailAndPasswordNull="Login was unsuccessful.";
            WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
            Login.click();
            MyFunc.wait(2);

            WebElement Mail= driver.findElement(By.cssSelector("input[class='email']"));
            Mail.sendKeys(mail);
            MyFunc.wait(2);

            WebElement Password= driver.findElement(By.cssSelector("input[class='password']"));
            Password.sendKeys(password);
            MyFunc.wait(2);




            WebElement in= driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
            in.click();
            MyFunc.wait(2);

            WebElement error= driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

           Assert.assertTrue(error.getText().contains(MailAndPasswordNull));


          BekleVeKapat();



        }
     @Test
    public void NegatifOturumAcma2(){
        driver.get("https://demowebshop.tricentis.com/");
        String Mail="iremt8202@gmail.com";
        String Password="";
        String nullPassword="Login was unsuccessful.";
         WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
         Login.click();
         MyFunc.wait(2);

         WebElement mail= driver.findElement(By.cssSelector("input[id='Email']"));
         mail.sendKeys(Mail);
         MyFunc.wait(2);

         WebElement password= driver.findElement(By.cssSelector("input[class='password']"));
         password.sendKeys(Password);
         MyFunc.wait(2);



         WebElement in= driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
         in.click();
         MyFunc.wait(2);

         WebElement errorr=driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

         Assert.assertTrue(errorr.getText().contains(nullPassword));

         BekleVeKapat();

     }
     @Test
    public void NegatifOturumAcma3() {
         driver.get("https://demowebshop.tricentis.com/");
         String mail = "";
         String password = "gtfeggh123AB";
         String unsuccessful = "Login was unsuccessful.";
         WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
         Login.click();
         MyFunc.wait(2);
         WebElement Mail = driver.findElement(By.cssSelector("input[id='Email']"));
         Mail.sendKeys(mail);
         MyFunc.wait(2);
         WebElement Password = driver.findElement(By.cssSelector("input[class='password']"));
         Password.sendKeys(password);
         MyFunc.wait(2);
         WebElement in= driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
         in.click();
         MyFunc.wait(2);
         WebElement error = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

         Assert.assertTrue(error.getText().contains(unsuccessful));

         BekleVeKapat();
     }
    @Test
    public void NegatifOturumAcma4(){
        driver.get("https://demowebshop.tricentis.com/");
        String mail="iremtmt@gmail.com";
        String password="khmfohmofj";
        String unsuccessful="Login was unsuccessful.";
        WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
        Login.click();
        MyFunc.wait(2);
        WebElement Mail = driver.findElement(By.cssSelector("input[id='Email']"));
        Mail.sendKeys(mail);
        MyFunc.wait(2);
        WebElement Password = driver.findElement(By.cssSelector("input[class='password']"));
        Password.sendKeys(password);
        MyFunc.wait(2);
        WebElement in= driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        in.click();
        MyFunc.wait(2);
        WebElement error = driver.findElement(By.xpath("//span[text()='Login was unsuccessful. Please correct the errors and try again.']"));

        Assert.assertTrue(error.getText().contains(unsuccessful));

        BekleVeKapat();
    }
    @Test
    public void OturumKapatma(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement Login = driver.findElement(By.cssSelector("a[class='ico-login']"));
        Login.click();
        MyFunc.wait(2);

        WebElement Mail = driver.findElement(By.cssSelector("input[id='Email']"));
        Mail.sendKeys("iremt8202@gmail.com");
        MyFunc.wait(2);

        WebElement Password = driver.findElement(By.cssSelector("input[type='password']"));
        Password.sendKeys("gtfeggh123AB");
        MyFunc.wait(2);

        WebElement in= driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        in.click();
        MyFunc.wait(2);

       WebElement Hesabim= driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]"));
       Hesabim.click();
       MyFunc.wait(2);

       WebElement LogOut= driver.findElement(By.xpath("//a[text()='Log out']"));
       LogOut.click();
       MyFunc.wait(2);

       BekleVeKapat();

    }
       @Test
    public void SearchBox(){
           driver.get("https://demowebshop.tricentis.com/");
           WebElement search= driver.findElement(By.cssSelector("input[type='text'][name='q']"));
           search.sendKeys("book");
           MyFunc.wait(2);
           WebElement product= driver.findElement(By.cssSelector("[class=\"button-1 search-box-button\"]"));
           product.click();

           BekleVeKapat();
       }





}
