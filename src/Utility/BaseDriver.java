package Utility;

import Utility.My.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    static {   //public static driverBaslat()
        Logger logger = Logger.getLogger("");//output yapılan logları at
        logger.setLevel(Level.SEVERE);//sadece errorları göster

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    }

    public static void BekleVeKapat() {

        MyFunc.wait(3);
        driver.quit();
    }
}

