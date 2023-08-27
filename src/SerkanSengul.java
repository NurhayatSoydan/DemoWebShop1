import Utility.BaseDriver;
import Utility.My.MyFunc;
import com.google.j2objc.annotations.Weak;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class SerkanSengul extends BaseDriver {
    @Test
    public void Ordering() {

        driver.get("https://demowebshop.tricentis.com/");

        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.name("Email"));
        Email.sendKeys("serkansengul2@gmail.com");

        WebElement passowrd = driver.findElement(By.id("Password"));
        passowrd.sendKeys("kobe21tmac");

        WebElement Login2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        Login2.click();

        MyFunc.wait(1);

        WebElement AddToCart = driver.findElement(By.cssSelector("[alt='Picture of Build your own cheap computer']"));
        AddToCart.click();
        MyFunc.wait(1);

        WebElement addcart = driver.findElement(By.cssSelector("[id='add-to-cart-button-72']"));
        addcart.click();
        MyFunc.wait(1);
        WebElement ShoppingList = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        ShoppingList.click();
        MyFunc.wait(2);

        WebElement agreebutton = driver.findElement(By.cssSelector("[id='termsofservice']"));
        agreebutton.click();
        MyFunc.wait(2);

        WebElement Checkout = driver.findElement(By.id("checkout"));
        Checkout.click();
        MyFunc.wait(1);

        WebElement cont = driver.findElement(By.xpath("(//input[@type='button'])[2]"));
        cont.click();
        MyFunc.wait(1);

        WebElement pickupsotre= driver.findElement(By.id("PickUpInStore"));
        pickupsotre.click();

        WebElement InStorePickUp = driver.findElement(By.xpath("(//input[@type='button'])[3]"));
        InStorePickUp.click();
        MyFunc.wait(1);

        WebElement VisibleText = driver.findElement(By.xpath("(//div[@style='display: none;'])[1]"));
        MyFunc.wait(1);

        Assert.assertFalse(VisibleText.isDisplayed());
        MyFunc.wait(1);


        WebElement onclick= driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        onclick.click();


        WebElement cont5 = driver.findElement(By.xpath("(//input[@type='button'])[5]"));
        cont5.click();
        MyFunc.wait(1);

        WebElement cont6 = driver.findElement(By.xpath("(//input[@type='button'])[6]"));
        cont6.click();
        MyFunc.wait(1);



        List<WebElement> price = driver.findElements(By.xpath("(//span[@class='product-price'])"));
        double toplam = 0;
        for (WebElement t : price) {
            System.out.println("t.getText() = " + t.getText());
            toplam += Double.parseDouble(t.getText().replaceAll("[^0-9,.]", ""));
        }

        System.out.println("toplam = " + toplam);
        WebElement ProductPriceTotal = driver.findElement(By.cssSelector("[class='product-price order-total']"));

        Double itemtotal = Double.parseDouble(ProductPriceTotal.getText().replaceAll("[^0-9,.]", ""));

        System.out.println("itemtotal = " + itemtotal);

        Assert.assertTrue("Değerler eşit değil", toplam == itemtotal);

        MyFunc.wait(1);
        WebElement confrim = driver.findElement(By.cssSelector("[onclick='ConfirmOrder.save()']"));
        confrim.click();
        MyFunc.wait(1);

        WebElement ConfrimShopping = driver.findElement(By.xpath("//div[@class='title']/*"));
        Assert.assertTrue(ConfrimShopping.isDisplayed());

        WebElement Continue2 = driver.findElement(By.cssSelector("[type='button']"));
        Continue2.click();


        BekleVeKapat();

    }

    @Test
    public void OrderDownload() throws AWTException {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.name("Email"));
        Email.sendKeys("serkansengul2@gmail.com");

        WebElement passowrd = driver.findElement(By.id("Password"));
        passowrd.sendKeys("kobe21tmac");

        WebElement Login2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        Login2.click();

        WebElement Account = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]"));
        Account.click();

        WebElement Orders = driver.findElement(By.xpath("(//a[@href='/customer/orders'])[1]"));
        Orders.click();

        MyFunc.wait(1);
        WebElement Details = driver.findElement(By.cssSelector("[class='button-2 order-details-button']"));
        Details.click();

        WebElement PDFDocument = driver.findElement(By.cssSelector("[href='/orderdetails/pdf/1500149']"));
        PDFDocument.click();

        Robot robot = new Robot();


        for (int i = 0; i < 26; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);

        }
        MyFunc.wait(2);
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);

        BekleVeKapat();
    }

    @Test
    public void SurveyAnswering() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.name("Email"));
        Email.sendKeys("serkansengul2@gmail.com");

        WebElement passowrd = driver.findElement(By.id("Password"));
        passowrd.sendKeys("kobe21tmac");

        WebElement Login2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        Login2.click();
        MyFunc.wait(1);

        driver.navigate().back();
        driver.navigate().back();

        WebElement Answer = driver.findElement(By.id("pollanswers-1"));
        Answer.click();
        MyFunc.wait(1);

        WebElement Vote = driver.findElement(By.id("vote-poll-1"));
        Vote.click();


        List<WebElement> Results = driver.findElements(By.xpath("//ul[@class='poll-results']/*"));
        for (WebElement re : Results) {
            wait.until(ExpectedConditions.visibilityOfAllElements(re));
            System.out.println("Results = " + re.getText());
        }

        BekleVeKapat();
    }

    @Test
    public void Continue_Shopping_After_Adding_A_Product() {

        driver.get("https://demowebshop.tricentis.com/");
        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.name("Email"));
        Email.sendKeys("serkansengul2@gmail.com");

        WebElement passowrd = driver.findElement(By.id("Password"));
        passowrd.sendKeys("kobe21tmac");

        WebElement Login2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        Login2.click();
        MyFunc.wait(1);

        WebElement ShoppingCart = driver.findElement(By.xpath("(//a[@href='/cart'])[1]"));
        ShoppingCart.click();

        WebElement ContinueShopping = driver.findElement(By.name("continueshopping"));
        ContinueShopping.click();

        WebElement Books = driver.findElement(By.xpath("(//a[@href='/books'])[3]"));
        Books.click();

        WebElement ClickBook = driver.findElement(By.xpath("(//input[@type='button'])[3]"));
        ClickBook.click();


        WebElement ShoppingCartRe = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        ShoppingCartRe.click();


        List<WebElement> Products = driver.findElements(By.cssSelector("[class='cart-item-row']"));
        for (WebElement po : Products) {
            System.out.println("Products = " + po.getText());
        }

        BekleVeKapat();
    }

    @Test
    public void RECENTLY_VIEWED_PRODUCTS() {
        driver.get("https://demowebshop.tricentis.com/");
        WebElement Login = driver.findElement(By.cssSelector("[href='/login']"));
        Login.click();

        WebElement Email = driver.findElement(By.name("Email"));
        Email.sendKeys("serkansengul2@gmail.com");

        WebElement passowrd = driver.findElement(By.id("Password"));
        passowrd.sendKeys("kobe21tmac");

        WebElement Login2 = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        Login2.click();
        MyFunc.wait(1);

        WebElement Computer = driver.findElement(By.cssSelector("[src='https://demowebshop.tricentis.com" +
                "/content/images/thumbs/0000224_141-inch-laptop_125.png']"));
        Computer.click();

        driver.navigate().back();

        WebElement WiewProduct = driver.findElement(By.cssSelector("[href='/recentlyviewedproducts']"));
        WiewProduct.click();

        driver.navigate().back();


        WebElement Pc = driver.findElement(By.cssSelector("[src='https://demowebshop.tricentis.com/content/images/thumbs" +
                "/0000201_build-your-own-expensive-computer_125.jpeg']"));

        Pc.click();

        WebElement WievProduct2 = driver.findElement(By.cssSelector("[href='/recentlyviewedproducts']"));
        WievProduct2.click();

        List<WebElement> Products = driver.findElements(By.cssSelector("[class='item-box']"));
        for (WebElement Po : Products) {
            System.out.println("Po.getText() = " + Po.getText());
        }
        BekleVeKapat();

    }


}





