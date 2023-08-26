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
    public void Test() {

        driver.get("https://demowebshop.tricentis.com/");
        Actions actions = new Actions(driver);

        WebElement Register = driver.findElement(By.cssSelector("[href='/register']"));
        Register.click();

        WebElement radiobutton = driver.findElement(By.id("gender-male"));
        radiobutton.click();

        WebElement FirstNaem = driver.findElement(By.id("FirstName"));
        FirstNaem.sendKeys("serkan");

        WebElement LastName = driver.findElement(By.id("LastName"));
        LastName.sendKeys("sengul");

        WebElement Email = driver.findElement(By.id("Email"));
        Email.sendKeys("tteck123@gmail.com");

        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("kobe21tmac");

        WebElement repassword = driver.findElement(By.id("ConfirmPassword"));
        repassword.sendKeys("kobe21tmac");

        WebElement registerbutton = driver.findElement(By.id("register-button"));
        registerbutton.click();

        driver.navigate().back();
        driver.navigate().back();
        MyFunc.wait(1);

        WebElement addProduct = driver.findElement(By.cssSelector("[alt='Picture of 14.1-inch Laptop']"));
        addProduct.click();
        MyFunc.wait(1);

        WebElement AddToCart = driver.findElement(By.id("add-to-cart-button-31"));
        AddToCart.click();

        WebElement ShoppingList = driver.findElement(By.xpath("(//span[@class='cart-label'])[1]"));
        ShoppingList.click();
        MyFunc.wait(1);

        WebElement agreebutton = driver.findElement(By.cssSelector("[id='termsofservice']"));
        agreebutton.click();
        MyFunc.wait(1);

        WebElement Checkout = driver.findElement(By.id("checkout"));
        Checkout.click();
        MyFunc.wait(1);


        WebElement Company = driver.findElement(By.id("BillingNewAddress_Company"));
        Company.sendKeys("KardeslerKundura");
        MyFunc.wait(1);

        WebElement SelectCountry = driver.findElement(By.id("BillingNewAddress_CountryId"));
        actions.moveToElement(SelectCountry).click().perform();

        Select select = new Select(SelectCountry);
        select.selectByValue("2");

        MyFunc.wait(1);

        WebElement SelectState = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        actions.moveToElement(SelectState).click().perform();

        Select select1 = new Select(SelectState);
        select1.selectByValue("63");

        MyFunc.wait(1);
        WebElement City = driver.findElement(By.id("BillingNewAddress_City"));
        City.sendKeys("İzmir");

        MyFunc.wait(1);
        WebElement Adress = driver.findElement(By.id("BillingNewAddress_Address1"));
        Adress.sendKeys("Cigli");
        MyFunc.wait(1);

        WebElement Adress1 = driver.findElement(By.id("BillingNewAddress_Address2"));
        Adress1.sendKeys("Cigli");
        MyFunc.wait(1);

        WebElement ZipPostalCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        ZipPostalCode.sendKeys("35000");
        MyFunc.wait(1);

        WebElement PhoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        PhoneNumber.sendKeys("5555202020");
        MyFunc.wait(1);

        WebElement FaxNumber = driver.findElement(By.id("BillingNewAddress_FaxNumber"));
        FaxNumber.sendKeys("564214841");
        MyFunc.wait(1);

        WebElement Continue = driver.findElement(By.cssSelector("[onclick='Billing.save()']"));
        Continue.click();
        MyFunc.wait(1);

        WebElement InStorePickUp = driver.findElement(By.id("PickUpInStore"));
        InStorePickUp.click();
        MyFunc.wait(1);

        WebElement VisibleText = driver.findElement(By.xpath("(//div[@style='display: none;'])[1]"));
        MyFunc.wait(1);

        Assert.assertFalse(VisibleText.isDisplayed());
        MyFunc.wait(1);


        WebElement Button = driver.findElement(By.cssSelector("[onclick='Shipping.save()']"));
        Button.click();
        MyFunc.wait(1);

        WebElement Cash = driver.findElement(By.cssSelector("[id='paymentmethod_0']"));
        Cash.click();
        MyFunc.wait(1);

        WebElement OnClick = driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        OnClick.click();
        MyFunc.wait(1);

        WebElement Payment = driver.findElement(By.xpath("//div[@class='info']/*/*/*/*/*"));
        Assert.assertTrue(Payment.isDisplayed());

        WebElement click = driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));
        click.click();
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
    public void SiparisIndirme() throws AWTException {
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

    }

    @Test
    public void AnketYanitlama() {
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


    }
}
