package Element;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static Driver.TestBase.driver;

public class Element {

    public WebElement findElement(By webElement){
        return driver.findElement(webElement);
    }

    public static WebElement ByName(String Name) throws AWTException, IOException {

        Set<String> j = driver.getWindowHandles();
        j.size();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("")));

        Wait<WebDriver> wait12 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(500))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement clickseleniumlink = wait12.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return new Element().findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
            }
        });
        //click on the selenium link
        clickseleniumlink.click();

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_A);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("document.getElementById(‘email').value='abc.efg@xyz.com'");
        js.executeScript("window.resizeTo(1024, 768)");

        Select dropdown = new Select(driver.findElement(By.name("")));
        dropdown.selectByIndex(5);
        dropdown.selectByValue("Books");
        dropdown.selectByVisibleText("The Alchemist");

        URL link = new URL(driver.findElement(By.name("")).getAttribute("href"));
        HttpURLConnection httpConn =(HttpURLConnection)link.openConnection();
        if(httpConn.getResponseCode()!= 200)
        {
            System.out.println("Broken Link");
        }

        Dimension d = new Dimension(400,600);
        driver.manage().window().setSize(d);

        return driver.findElement(By.name(Name));
    }

}
