import Utility.BaseDriver;
import Utility.My.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SerkanOzsahin extends BaseDriver {

    @Test
    public void CreateAccountPositive() {

        String enterPassword = "123qwe";
        String registerConfirm = "Your registration completed";

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);

        WebElement registerBtn = driver.findElement(By.xpath("//a[text()='Register']"));
        registerBtn.click();
        MyFunc.wait(1);

        WebElement genderSelect = driver.findElement(By.id("gender-male"));
        genderSelect.click();
        MyFunc.wait(1);

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Andriy");
        MyFunc.wait(1);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Shevchenko");
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("ozsserkan459@gmail.com");
        MyFunc.wait(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement confirmPassWord = driver.findElement(By.id("ConfirmPassword"));
        confirmPassWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement submitBtn = driver.findElement(By.id("register-button"));
        submitBtn.click();
        MyFunc.wait(1);

        WebElement registerCheck = driver.findElement(By.xpath("//div[@class='result']"));

        Assert.assertTrue("Bilgiler doğru girilmesine rağmen yeni hesap oluşturulamadı. Test FAILED.", registerCheck.getText().contains(registerConfirm));

        System.out.println("\u001B[94mCreateAccountPositive = \u001B[0m" + "\u001B[32m" + "Hesap bilgileri başarılı bir şekilde girildi." + "\u001B[0m");
        System.out.println("\u001B[94mCreateAccountPositive = \u001B[0m" + "\u001B[32m" + "Hesap başarıyla oluşturuldu." + "\u001B[0m");
        System.out.println("\u001B[94mCreateAccountPositive = \u001B[0m" + "\u001B[32m" + "Hesap açma işlemi başarıyla bitirildi mesajı ekrana geldi." + "\u001B[0m");
        System.out.println("\u001B[32m" + "Test PASSED." + "\u001B[0m");

        BekleVeKapat();
    }

    @Test
    public void CreateAccountNegative() {

        String enterPassword = "123qwe";
        String registerConfirm = "The specified email already exists";

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);

        WebElement registerBtn = driver.findElement(By.xpath("//a[text()='Register']"));
        registerBtn.click();
        MyFunc.wait(1);

        WebElement genderSelect = driver.findElement(By.id("gender-male"));
        genderSelect.click();
        MyFunc.wait(1);

        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Andriy");
        MyFunc.wait(1);

        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Shevchenko");
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys("ozsserkan459@gmail.com");
        MyFunc.wait(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement confirmPassWord = driver.findElement(By.id("ConfirmPassword"));
        confirmPassWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement submitBtn = driver.findElement(By.id("register-button"));
        submitBtn.click();
        MyFunc.wait(1);

        WebElement registerCheck = driver.findElement(By.xpath("//*[text()='The specified email already exists']"));

        Assert.assertTrue("Aynı e-mail ile kayıt olunmasına rağmen ekrana uyarı gelmedi. Test FAILED.", registerCheck.getText().contains(registerConfirm));

        System.out.println("\u001B[94mCreateAccountNegative = \u001B[0m" + "\u001B[32m" + "Hesap bilgileri başarılı bir şekilde girildi." + "\u001B[0m");
        System.out.println("\u001B[94mCreateAccountNegative = \u001B[0m" + "\u001B[32m" + "Girilen e-mail sistemde mevcut uyarısı ekrana geldi." + "\u001B[0m");
        System.out.println("\u001B[94mCreateAccountNegative = \u001B[0m" + "\u001B[32m" + "Hesap oluşturulamadı." + "\u001B[0m");
        System.out.println("\u001B[32m" + "Test PASSED." + "\u001B[0m");

        BekleVeKapat();
    }

    @Test
    public void GiftCard() {

        String Id = "ozsserkan459@gmail.com";
        String enterPassword = "123qwe";
        String myOrder = "14.1-inch Laptop";
        String couponNumbers = "123aa";
        String couponCheck = "The coupon code you entered couldn't be applied to your order";
        String giftCardNumbers = "123bbb";
        String orderCheck = "Your order has been successfully processed!";

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);

        WebElement logInBtn = driver.findElement(By.className("ico-login"));
        logInBtn.click();
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys(Id);
        MyFunc.wait(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement logInBtn2 = driver.findElement(By.xpath(("(//input[@type='submit'])[2]")));
        logInBtn2.click();
        MyFunc.wait(1);

        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
        MyFunc.wait(1);

        Actions actionA = new Actions(driver);
        Action action2 = actionA.moveToElement(computers).build();
        action2.perform();
        MyFunc.wait(1);

        WebElement noteBooks = driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        noteBooks.click();
        MyFunc.wait(1);

        WebElement addToBtn = driver.findElement(By.cssSelector("[value='Add to cart']"));
        addToBtn.click();
        MyFunc.wait(1);

        WebElement myCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        myCart.click();
        MyFunc.wait(1);

        WebElement myOrder2 = driver.findElement(By.xpath("(//a[text()='14.1-inch Laptop'])[2]"));
        MyFunc.wait(1);

        Assert.assertTrue("Seçtiğim ürün ile sepetimdeki ürün farklı. Test FAILED.", myOrder2.getText().contains(myOrder));

        WebElement couponCode = driver.findElement(By.className("discount-coupon-code"));
        couponCode.sendKeys(couponNumbers);
        MyFunc.wait(1);

        WebElement applyCoupon = driver.findElement(By.name("applydiscountcouponcode"));
        applyCoupon.click();
        MyFunc.wait(1);

        WebElement couponText = driver.findElement(By.className("message"));
        MyFunc.wait(1);

        Assert.assertTrue("Yanlış kupon numarası girilmesine rağmen sistem kuponu kabul etti. Test FAILED.", couponText.getText().contains(couponCheck));

        WebElement applyGiftCard = driver.findElement(By.className("gift-card-coupon-code"));
        applyGiftCard.sendKeys(giftCardNumbers);
        MyFunc.wait(1);

        WebElement giftCardBtn = driver.findElement(By.name("applygiftcardcouponcode"));
        giftCardBtn.click();
        MyFunc.wait(1);

        WebElement tosCheck = driver.findElement(By.id("termsofservice"));
        tosCheck.click();
        MyFunc.wait(1);

        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();
        MyFunc.wait(1);

        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        MyFunc.wait(1);

        if (country.isDisplayed()) {

            Select ddMenu = new Select(country);
            MyFunc.wait(1);

            ddMenu.selectByVisibleText("Turkey");
            MyFunc.wait(1);

            WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
            city.sendKeys("İstanbul");
            MyFunc.wait(1);

            WebElement adress = driver.findElement(By.id("BillingNewAddress_Address1"));
            adress.sendKeys("Ataköy");
            MyFunc.wait(1);

            WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCode.sendKeys("0034");
            MyFunc.wait(1);

            WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneNumber.sendKeys("000122333");
            MyFunc.wait(1);
        }

        for (int i = 1; i <= 5; i++) {

            WebElement contBtn = driver.findElement(By.xpath("(//input[@value='Continue'])[" + i + "]"));
            contBtn.click();
            MyFunc.wait(1);
        }

        WebElement confirmBtn = driver.findElement(By.xpath("//input[@value='Confirm']"));
        confirmBtn.click();
        MyFunc.wait(1);

        WebElement confirmMsg = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));

        Assert.assertTrue(confirmMsg.getText().contains(orderCheck));

        System.out.println("\u001B[94mGiftCard = \u001B[0m" + "\u001B[32m" + "Hesap bilgileri başarılı bir şekilde girildi." + "\u001B[0m");
        System.out.println("\u001B[94mGiftCard = \u001B[0m" + "\u001B[32m" + "Seçilen ürün ile sepetteki ürünün aynı olduğu kontrol edildi." + "\u001B[0m");
        System.out.println("\u001B[94mGiftCard = \u001B[0m" + "\u001B[32m" + "Yanlış kupon girdiniz uyarısı ekrana geldi." + "\u001B[0m");
        System.out.println("\u001B[94mGiftCard = \u001B[0m" + "\u001B[32m" + "Siparişiniz onaylandı yazısı ekrana geldi." + "\u001B[0m");
        System.out.println("\u001B[32m" + "Test PASSED." + "\u001B[0m");

        BekleVeKapat();
    }

    @Test
    public void ChangePassword() {

        String Id = "ozsserkan459@gmail.com";
        String enterPassword = "123qwe";
        String enterNewPassword = "456rty";
        String passwordChangeText = "Password was changed";

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);

        WebElement logInBtn = driver.findElement(By.className("ico-login"));
        logInBtn.click();
        MyFunc.wait(1);

        WebElement eMail = driver.findElement(By.id("Email"));
        eMail.sendKeys(Id);
        MyFunc.wait(1);

        WebElement passWord = driver.findElement(By.id("Password"));
        passWord.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement logInBtn2 = driver.findElement(By.xpath(("(//input[@type='submit'])[2]")));
        logInBtn2.click();
        MyFunc.wait(1);

        WebElement myAcc = driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]"));
        myAcc.click();
        MyFunc.wait(1);

        WebElement changePassword = driver.findElement(By.xpath("//a[text()='Change password']"));
        changePassword.click();
        MyFunc.wait(1);

        WebElement oldPassword = driver.findElement(By.id("OldPassword"));
        oldPassword.sendKeys(enterPassword);
        MyFunc.wait(1);

        WebElement newPassword = driver.findElement(By.id("NewPassword"));
        newPassword.sendKeys(enterNewPassword);
        MyFunc.wait(1);

        WebElement confirmNewPassword = driver.findElement(By.id("ConfirmNewPassword"));
        confirmNewPassword.sendKeys(enterNewPassword);
        MyFunc.wait(1);

        WebElement changePasswordBtn = driver.findElement(By.xpath("//input[@value='Change password']"));
        changePasswordBtn.click();
        MyFunc.wait(1);

        WebElement passwordChangeConfirm = driver.findElement(By.className("result"));
        MyFunc.wait(1);

        Assert.assertTrue("Şifre değiştirilemedi. Test FAILED.", passwordChangeConfirm.getText().contains(passwordChangeText));

        System.out.println("\u001B[94mChangePassword = \u001B[0m" + "\u001B[32m" + "Hesap bilgileri başarılı bir şekilde girildi." + "\u001B[0m");
        System.out.println("\u001B[94mChangePassword = \u001B[0m" + "\u001B[32m" + "Yeni şifre yazıldı." + "\u001B[0m");
        System.out.println("\u001B[94mChangePassword = \u001B[0m" + "\u001B[32m" + "Şifreniz değişti yazısı ekrana geldi." + "\u001B[0m");
        System.out.println("\u001B[32m" + "Test PASSED." + "\u001B[0m");

        BekleVeKapat();
    }
}
