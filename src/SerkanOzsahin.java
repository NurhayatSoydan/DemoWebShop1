import Utility.BaseDriver;
import Utility.My.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
