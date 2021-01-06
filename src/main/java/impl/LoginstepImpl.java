package impl;

import Driver.driver;
import Element.Element;
import gherkin.lexer.Ro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.TestUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginstepImpl {

    WebDriver driver;

    @FindBy(name = "email")
    WebElement email;


    public void ajax(){
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
        System.out.println(driver.findElement(By.cssSelector("div#ajaxdiv")).findElement(By.tagName("p")).getText());
    }

    public LoginstepImpl(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void newtest(){
        System.out.println("Starting first case");
        email.sendKeys("Akhil");
    }

    public void verifyTitle(){
        String title = new driver().getTitle();
        System.out.println(title);
        Assert.assertEquals("Facebook – log in or sign up", title);
//        new Element().findElement(By.id(""));
//        Element.ByName("");
    }

    public void selectdropdown() throws InterruptedException, IOException {
        //        WebElement select = new Element().findElement(By.id("dropdown"));
//        Select select1 = new Select(select);
//        select1.selectByIndex(1);
//        new Element().findElement(By.tagName("button")).click();

//        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

//        driver.get("http://the-internet.herokuapp.com/broken_images");
//        List<WebElement> images = driver.findElements(By.tagName("img"));
//        for(int i=0;i<images.size();i++) {
//            URL url = new URL(images.get(i).getAttribute("src"));
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            if(connection.getResponseCode() != 200)
//            {
//                System.out.println("The image is broken");
//            }
//            System.out.println("Response code is "+connection.getResponseCode());
//        }

        driver.get("http://the-internet.herokuapp.com/challenging_dom");
//        WebElement yo = new Element().findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/table/tbody/tr[5]/td[4]"));
//        Actions actions =new Actions(driver);
//        actions.moveToElement(yo).doubleClick().perform();

        List<WebElement> yooy = driver.findElements(By.xpath("//a[@href='#edit']"));
        System.out.println("No of edit are "+yooy.size());
        yooy.get(4).click();

        Thread.sleep(2000);
    }

    public void getDataFromExcel(){
        TestUtil.getTestData("contacts");
    }
}
