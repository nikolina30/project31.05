
/*Napisati dva smoke testa za https://www.telerik.com/support/demos:
Proveriti da klikom na Desktop odlazimo na tu sekciju
Proveriti da klikom na Mobile odlazimo na tu sekciju
Koristiti TestNG, asserte.*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class Main {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.navigate().to("https://www.telerik.com/support/demos");
        driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void goToDesktop() {
        WebElement desktopTab = driver.findElement(By.linkText("Desktop"));
        desktopTab.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void goToMobile() {
        WebElement mobileTab = driver.findElement(By.linkText("Mobile"));
        mobileTab.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testDesktopHeaderTitle1() {
        String labelName1 = "Telerik UI for .NET MAUI";
        WebElement divTelerikDotNet = driver.findElement(By.id("ContentPlaceholder1_C337_Col00"));
        WebElement labelNameTelerikDotNet = divTelerikDotNet.findElement(By.className("TK-New"));
        Assert.assertEquals(labelName1, labelNameTelerikDotNet.getText());
    }

    @Test
    public void testDesktopHeaderTitle2() {
        String labelName2 = "Telerik UI for WinUI";
        WebElement divTelerikWinUI = driver.findElement(By.id("ContentPlaceholder1_C337_Col01"));
        WebElement labelNameTelerikWinUI = divTelerikWinUI.findElement(By.tagName("h4"));
        Assert.assertEquals(labelName2, labelNameTelerikWinUI.getText());
    }

    @Test
    public void testDesktopHeaderTitle3() {
        String labelName3 = "Telerik UI for WinForms";
        WebElement divTelerikWebForms = driver.findElement(By.id("ContentPlaceholder1_C337_Col02"));
        WebElement labelNameTelerikWebForms = divTelerikWebForms.findElement(By.tagName("h4"));
        Assert.assertEquals(labelName3, labelNameTelerikWebForms.getText());
    }

    @Test
    public void testMobileHeaderTitle1() {
        String labelName3 = "Telerik UI for .NET MAUI";
        WebElement divTelerikWebFormsMobile = driver.findElement(By.id("ContentPlaceholder1_C340_Col00"));
        WebElement labelNameTelerikWebFormsMobile = divTelerikWebFormsMobile.findElement(By.className("TK-New"));
        Assert.assertEquals(labelName3, labelNameTelerikWebFormsMobile.getText());
    }

    @Test
    public void testMobileHeaderTitle2() {
        String labelName3 = "Telerik UI for Xamarin";
        WebElement divTelerikWebFormsMobile = driver.findElement(By.id("ContentPlaceholder1_C340_Col01"));
        WebElement labelNameTelerikWebFormsMobile = divTelerikWebFormsMobile.findElement(By.tagName("h4"));
        Assert.assertEquals(labelName3, labelNameTelerikWebFormsMobile.getText());
    }

    @AfterClass
    public void afterMethod(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}
